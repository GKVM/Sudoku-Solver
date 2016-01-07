package checkers

import play.Logger
import sudoku.SudokuModel

/**
  * Created by Gopikrishna VM on 04-01-2016.
  */
object MatrixVerify {
  def verifyMatrix(sudokuModel: SudokuModel): Int = {
    var wrongCounter = 0
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if (!sudokuModel.matrix(i)(j).equals(0)) {
          val rowRepetition = Checkers.rowCheck(i, sudokuModel.matrix(i)(j), sudokuModel.matrix)
          val columnRepetition = Checkers.columnCheck(j, sudokuModel.matrix(i)(j), sudokuModel.matrix)
          val boxRepetition = Checkers.boxCheck(i, j, sudokuModel.matrix(i)(j), sudokuModel.matrix)
          //Logger.info("\n"+sudokuModel.matrix(i)(j)+" "+i+" "+j+"Row:" + rowRepetition + "\nColumn:" + columnRepetition + "\nBox:" + rowRepetition)
          if ((rowRepetition != 1) ||
            (columnRepetition != 1) ||
            (boxRepetition != 1)) {
            wrongCounter += 1
            sudokuModel.errorLocations(i)(j) = sudokuModel.matrix(i)(j)
          }
        }
      }
    }
    Logger.info("Problems found: " + wrongCounter)
    wrongCounter
  }
}
