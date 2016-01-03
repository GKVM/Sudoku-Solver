package processor

import checkers.Checkers
import sudoku.SudokuModel

/**
  * Created by Gopikrishna VM on 31-12-2015.
  * http://www.websudoku.com/images/example-steps.html
  */
object FillAlgorithm1 {

  def createPossibilityMatrix(sudokuModel: SudokuModel): Unit = {
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if (sudokuModel.matrix(i)(j).equals(0)) {
          for (number <- 1 to 9) {
            if (Checkers.rowCheck(i, number, sudokuModel.matrix).equals(0) &&
              Checkers.columnCheck(j, number, sudokuModel.matrix).equals(0) &&
              Checkers.boxCheck(i, j, number, sudokuModel.matrix).equals(0)) {
              sudokuModel.possibilitiesCount(i)(j) += 1
              val count: Int = sudokuModel.possibilitiesCount(i)(j)
              sudokuModel.possibilitiesMatrix(i)(j)(count - 1) = number
            }
          }
        }
      }
    }
  }

  def fillForSinglePossibility(sudokuModel: SudokuModel): Unit = {
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if (sudokuModel.possibilitiesCount(i)(j).equals(1) && sudokuModel.matrix(i)(j).equals(0)) {
          sudokuModel.matrix(i)(j) = sudokuModel.possibilitiesMatrix(i)(j)(sudokuModel.possibilitiesCount(i)(j)-1)
        }
      }
    }
  }

  def clearPossibility(sudokuModel: SudokuModel): Unit = {
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        sudokuModel.possibilitiesCount(i)(j) = 0
      }
    }
  }
}
