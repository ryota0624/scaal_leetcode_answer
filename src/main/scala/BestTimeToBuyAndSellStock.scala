object BestTimeToBuyAndSellStock {
  object Solution {
    def maxProfit(prices: Array[Int]): Int = {
      if (prices.isEmpty) return 0
      var buyPrice = prices.head
      var profit = 0
      for (price <- prices.tail) {
        if (price < buyPrice) {
          buyPrice = price
        }

        val p = price - buyPrice
        if (p > profit) {
          profit = p
        }
      }
      profit
    }
  }
}
