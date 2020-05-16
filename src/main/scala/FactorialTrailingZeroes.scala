object FactorialTrailingZeroes {

  object Solution {
    def factorial(n: Int): Int = n match {
      case _ if n == 1 => n
      case _ if n == 0 => 0
      case _ => n * factorial(n - 1)
    }

    def trailingZeroes(n: Int): Int =
      if (n == 0) 0 else (n / 5) + trailingZeroes(n / 5)


    def countTrailingZeroes(n: Int, memo: Int = 0): Int = {
      if (n <= 0) memo
      else {
        val lastNumber = n % 10
        val remain = n / 10
        val add = if (lastNumber == 0 && remain > 10) 1 else 0
        countTrailingZeroes(remain, add + memo)
      }
    }

    def countTrailingTailZero(n: Int, memo: Int = 0): Int = {
      if (n <= 0) memo
      else {
        val lastNumber = n % 10
        if (lastNumber == 0) countTrailingTailZero(n / 10, 1 + memo)
        else memo
      }
    }
  }

}
