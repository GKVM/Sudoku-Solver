package processor

import sudoku.SudokuModel
import play.api.Logger

/**
  * Created by Gopikrishna VM on 03-01-2016.
  */
object DifficultyChecker{

  def checkDifficulty(sudokuModel: SudokuModel): Int = {
    var unfilledCells = 0
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if (sudokuModel.matrix(i)(j).equals(0)) {
          unfilledCells += 1
        }
      }
    }
    Logger.info("Number of unfilled cells: " + unfilledCells)
    unfilledCells
  }
}