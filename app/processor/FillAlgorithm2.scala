package processor

import checkers.{BoxLimits, Checkers}
import play.Logger
import sudoku.SudokuModel

/**
  * Created by Gopikrishna VM on 06-01-2016.
  */
object FillAlgorithm2 {

  def boxPossibilityChecker(sudokuModel: SudokuModel): Unit = {
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if (sudokuModel.matrix(i)(j) == 0) {
          for (number <- 1 to 9) {
            Logger.info("Box possibility " + number + " " + i + " " + j + " " + possibilityInOtherCell(i, j, number, sudokuModel))
            if (possibilityInOtherCell(i, j, number, sudokuModel) == 1 &&
              Checkers.rowCheck(i, number, sudokuModel.matrix) == 0 &&
              Checkers.columnCheck(j, number, sudokuModel.matrix) == 0 &&
              Checkers.boxCheck(i, j, number, sudokuModel.matrix) == 0) {
              sudokuModel.possibilitiesCount(i)(j)+=1
              val count: Int =sudokuModel.possibilitiesCount(i)(j)
              sudokuModel.possibilitiesMatrix(i)(j)(count-1)=number
            }
          }
        }
      }
    }
  }

  /** Checks if a number can ba placed in any cell of a box.
    *
    * @param rowNumber
    * @param columnNumber
    * @param number
    * @param sudokuModel
    * @return count of cells the number can be placed.
    */
  private def possibilityInOtherCell(rowNumber: Int, columnNumber: Int, number: Int, sudokuModel: SudokuModel): Int = {
    var count: Int = 0
    val rowLower: Int = BoxLimits.cellBoxLowLimitFinder(rowNumber)
    val rowUpper: Int = BoxLimits.cellBoxHighLimitFinder(rowNumber)
    val columnLower: Int = BoxLimits.cellBoxLowLimitFinder(columnNumber)
    val columnUpper: Int = BoxLimits.cellBoxHighLimitFinder(columnNumber)
    for (i <- rowLower to rowUpper) {
      for (j <- columnLower to columnUpper) {
        if (sudokuModel.matrix(i)(j) == 0) {
          if (Checkers.rowCheck(i, number, sudokuModel.matrix) == 0 &&
            Checkers.columnCheck(j, number, sudokuModel.matrix) == 0 &&
            Checkers.boxCheck(i, j, number, sudokuModel.matrix) == 0) {
            {
              count += 1
            }
          }
        }
      }
    }
    count
  }
}