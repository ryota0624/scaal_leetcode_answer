import org.scalatest.{FunSuite, Matchers}

class MatrixBlockSumTest extends FunSuite with Matchers {
  test("mat = ((1,2,3),(4,5,6),(7,8,9)), K = 1") {
    MatrixBlockSum.Solution.matrixBlockSum(
      Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)),
      1
    ) shouldEqual Array(Array(12, 21, 16), Array(27, 45, 33), Array(24, 39, 28))
  }

}
