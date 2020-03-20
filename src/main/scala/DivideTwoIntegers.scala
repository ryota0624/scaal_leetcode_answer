object DivideTwoIntegers {
  def divide(dividend: Int, divisor: Int): Int = {
    (dividend.toDouble / divisor.toDouble).toInt
  }
}