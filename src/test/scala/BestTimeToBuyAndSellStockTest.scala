import org.scalatest.{FunSuite, Matchers}

class BestTimeToBuyAndSellStockTest extends FunSuite with Matchers {
  test("[7,1,5,3,6,4] -> 5") {
    BestTimeToBuyAndSellStock.Solution.maxProfit(Array(7, 1, 5, 3, 6, 4)) should be(
      5
    )
  }

  test("[7,6,4,3,1] -> 0") {
    BestTimeToBuyAndSellStock.Solution.maxProfit(Array(7, 6, 4, 3, 1)) should be(
      0
    )
  }
}
