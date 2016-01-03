package controllers

import play.api.mvc.{Action, Controller}
import processor.{DifficultyChecker, FillAlgorithm1}
import sudoku.SudokuModel

/**
  * Created by Gopikrishna VM on 31-12-2015.
  */

object PuzzleReceiver extends Controller {

  def puzzlePost = Action(parse.text) {
    implicit request =>
      println("Puzzle:\n" + request.body)
      val sudokuModel = new SudokuModel
      sudokuModel.getMatrix(request.body)
      sudokuModel.printMatrix
      var previousUnfilled = 0
      var currentUnfilled = DifficultyChecker.checkDifficulty(sudokuModel)
      do {
        previousUnfilled = currentUnfilled
        FillAlgorithm1.createPossibilityMatrix(sudokuModel)
        FillAlgorithm1.fillForSinglePossibility(sudokuModel)
        FillAlgorithm1.clearPossibility(sudokuModel)
        currentUnfilled = DifficultyChecker.checkDifficulty(sudokuModel)
      } while (currentUnfilled < previousUnfilled)
      FillAlgorithm1.createPossibilityMatrix(sudokuModel)
      sudokuModel.printPossibilitiesCount
      sudokuModel.printMatrix

      Ok("Status success"
        + sudokuModel.returnMatrix)
  }
}