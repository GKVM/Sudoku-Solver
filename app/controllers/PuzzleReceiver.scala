package controllers

import checkers.MatrixVerify
import play.api.mvc.{Action, Controller}
import processor.{FillAlgorithm2, DifficultyChecker, FillAlgorithm1}
import sudoku.SudokuModel

/**
  * Created by Gopikrishna VM on 31-12-2015.
  */

object PuzzleReceiver extends Controller {

  def puzzlePost = Action(parse.text) {
    implicit request =>
      println("Puzzle:\n" + request.body)
      val sudoku = new SudokuModel
      sudoku.getMatrix(request.body)
      sudoku.printMatrix

      if (MatrixVerify.verifyMatrix(sudoku) != 0) {
        sudoku.printErrorLocations
        Ok("Incorrect puzzle.")
      }
      else {
        var previousUnfilled = 0
        var currentUnfilled = DifficultyChecker.checkDifficulty(sudoku)
        do {
          previousUnfilled = currentUnfilled
          FillAlgorithm1.clearPossibility(sudoku)
          FillAlgorithm1.createPossibilityMatrix(sudoku)
          FillAlgorithm1.fillForSinglePossibility(sudoku)
          FillAlgorithm1.clearPossibility(sudoku)
          FillAlgorithm2.boxPossibilityChecker(sudoku)
          FillAlgorithm1.fillForSinglePossibility(sudoku)
          sudoku.printMatrix
          MatrixVerify.verifyMatrix(sudoku)
          currentUnfilled = DifficultyChecker.checkDifficulty(sudoku)
        } while (currentUnfilled < previousUnfilled)
        FillAlgorithm1.createPossibilityMatrix(sudoku)

        sudoku.printPossibilitiesCount
        sudoku.printMatrix
        if (MatrixVerify.verifyMatrix(sudoku) != 0) {
          sudoku.printErrorLocations
        }
        Ok(sudoku.returnMatrix)
      }
  }
}