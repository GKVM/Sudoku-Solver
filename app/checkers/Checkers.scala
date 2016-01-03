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
    val rowLower: Int = cellBoxLowLimitFinder(rowNumber)
    val rowUpper: Int = cellBoxHighLimitFinder(rowNumber)
    val columnLower: Int = cellBoxLowLimitFinder(columnNumber)
    val columnUpper: Int = cellBoxHighLimitFinder(columnNumber)
    for (i <- rowLower to rowUpper) {
      for (j <- columnLower to columnUpper) {
        if (matrix(i)(j).equals(number)) {
          occurrence += 1
        }
      }
    }
    occurrence
  }

  def cellBoxLowLimitFinder(number: Int): Int = number match {
    case 0 => 0
    case 1 => 0
    case 2 => 0
    case 3 => 3
    case 4 => 3
    case 5 => 3
    case 6 => 6
    case 7 => 6
    case 8 => 6
  }

  def cellBoxHighLimitFinder(number: Int): Int = number match {
    case 0 => 2
    case 1 => 2
    case 2 => 2
    case 3 => 5
    case 4 => 5
    case 5 => 5
    case 6 => 8
    case 7 => 8
    case 8 => 8
  }
}
