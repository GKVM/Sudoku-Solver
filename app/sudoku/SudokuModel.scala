package sudoku

import scala.Array.ofDim

/**
  * Created by Gopikrishna VM on 31-12-2015.
  */
class SudokuModel {
  var matrix = ofDim[Int](9, 9)
  var possibilitiesMatrix = ofDim[Int](9, 9, 9)
  var possibilitiesCount = ofDim[Int](9, 9)
  var errorLocations = ofDim[Int](9, 9)

  def getMatrix(matrixStream: String) {
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        val pos = (i * 10 + j) // i*10 instead of 9 to discard new line character in input.
        matrix(i)(j) = matrixStream.charAt(pos) - 48
      }
    }
  }

  def printMatrix: Unit = {
    println("\nMatrix:")
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if(matrix(i)(j).equals(0)){
          print("_ ")
        }
        else
        print(matrix(i)(j) + " ")
      }
      println
    }
  }

  def returnMatrix: String = {
    val matrixString = new StringBuilder
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        matrixString.append(matrix(i)(j))
      }
      matrixString.append("\n")
    }
    matrixString.toString
  }

  def printPossibilitiesCount: Unit ={
    println("\nPossibilities count:")
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if(possibilitiesCount(i)(j).equals(0)){
            print("_ ")
        }
        else
        print(possibilitiesCount(i)(j) + " ")
      }
      println
    }
  }
  def printErrorLocations: Unit ={
    println("\nError Locations:")
    for (i <- 0 to 8) {
      for (j <- 0 to 8) {
        if(errorLocations(i)(j).equals(0)){
          print("_ ")
        }
        else
          print(errorLocations(i)(j) + " ")
      }
      println
    }
  }
}
