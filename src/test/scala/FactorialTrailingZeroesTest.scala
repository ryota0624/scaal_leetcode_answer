import org.scalatest.FunSuite

class FactorialTrailingZeroesTest extends FunSuite {
  {
    testTrailingZeroes(3, 0)

    testTrailingZeroes(5, 1)

    testTrailingZeroes(13, 2)

    testTrailingZeroes(7, 1)

    testTrailingZeroes(12, 2)

    def testTrailingZeroes(n: Int, expect: Int) = {
      test(s"input = $n") {
        info(s"input = $n, factorial = ${FactorialTrailingZeroes.Solution.factorial(n)}, expect = $expect")
        assert(FactorialTrailingZeroes.Solution.trailingZeroes(n) == expect)
      }
    }
  }


  test("countTrailingTailZero") {
    assert(FactorialTrailingZeroes.Solution.countTrailingTailZero(1) == 0)
    assert(FactorialTrailingZeroes.Solution.countTrailingTailZero(10) == 1)
    assert(FactorialTrailingZeroes.Solution.countTrailingTailZero(100) == 2)
    assert(FactorialTrailingZeroes.Solution.countTrailingTailZero(101) == 0)
  }


  test("factorial") {
    assert(FactorialTrailingZeroes.Solution.factorial(5) == 120)
    assert(FactorialTrailingZeroes.Solution.factorial(3) == 6)
    assert(FactorialTrailingZeroes.Solution.factorial(13) == 1932053504)
    assert(FactorialTrailingZeroes.Solution.factorial(7) == 5040)
    assert(FactorialTrailingZeroes.Solution.factorial(12) == 479001600)

  }
}
