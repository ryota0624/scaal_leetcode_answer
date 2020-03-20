object ReverseInteger {
  def reverse(x: Int): Int = {
    val finisher: Double => Double = if (x < 0) (n: Double) => -n
    else identity
    val r = finisher(_reverse(x.abs, 0, 1))
    if (r > Int.MaxValue || r < Int.MinValue) return 0
    else r.toInt
  }

  @scala.annotation.tailrec
  def _reverse(remaining: Int, sum: Double, numberOfDigits: Int): Double = {
    if (remaining == 0) sum
    else {
      val dividedOfCurrent = remaining.toDouble / 10
      val decimalOfCurrent = dividedOfCurrent % 1
      val current = (((decimalOfCurrent * 100) / 10).round)
      _reverse(remaining / 10, current.toInt + (sum * 10), numberOfDigits + 1)
    }
  }

  def main(args: Array[String]): Unit = {
    println(reverse(123))
    println(reverse(-123))
    println(reverse(120))
    println(reverse(901000))
    println(reverse(1534236469))
    println(reverse(-2147483412))
  }
}
