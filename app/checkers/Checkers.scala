package checkers
/**
  * Created by Gopikrishna VM on 31-12-2015.
  */
object Checkers{

  def rowCheck(rowNumber: Int, number: Int, matrix: Array[Array[Int]]): Int = {
    var occurrence: Int = 0
    for (j <- 0 to 8) {
      if (matrix(rowNumber)(j).equals(number)) {
        occurrence += 1
      }
    }
    occurrence
  }

  def columnCheck(columnNumber: Int, number: Int, matrix: Array[Array[Int]]): Int = {
    var occurrence: Int = 0
    for (i <- 0 to 8) {
      if (matrix(i)(columnNumber).equals(number)) {
        occurrence += 1
      }
    }
    occurrence
  }

  def boxCheck(rowNumber: Int, columnNumber: Int, number: Int, matrix: Array[Array[Int]]): Int = {
    var occurrence: Int = 0
    val rowLower: Int = BoxLimits.cellBoxLowLimitFinder(rowNumber)
    val rowUpper: Int = BoxLimits.cellBoxHighLimitFinder(rowNumber)
    val columnLower: Int = BoxLimits.cellBoxLowLimitFinder(columnNumber)
    val columnUpper: Int = BoxLimits.cellBoxHighLimitFinder(columnNumber)
    for (i <- rowLower to rowUpper) {
      for (j <- columnLower to columnUpper) {
        if (matrix(i)(j).equals(number)) {
          occurrence += 1
        }
      }
    }
    occurrence
  }


}
