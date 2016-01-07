package checkers

/**
  * Created by Gopikrishna VM on 06-01-2016.
  */
object BoxLimits {
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
