import org.scalatest.{FunSuite, Matchers}

class MinCostClimbingStairsTest extends FunSuite with Matchers {
  test("[10, 15, 20] -> 15") {
    MinCostClimbingStairs.Solution.minCostClimbingStairs(Array(10, 15, 20)) should be(
      15
    )
  }

  test("[1, 100, 1, 1, 1, 100, 1, 1, 100, 1] -> 6") {
    MinCostClimbingStairs.Solution.minCostClimbingStairs(
      Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)
    ) should be(6)
  }
}
