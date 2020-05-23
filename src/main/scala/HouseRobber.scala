object HouseRobber {
  object Solution {
    def rob(nums: Array[Int]): Int = {
      var oddStartMoneyTotal = 0
      var evenStartMoneyTotal = 0
      for {
        (amountOfMoney, houseNumber) <- nums.zipWithIndex
      } {
        if (houseNumber % 2 == 0) {
          evenStartMoneyTotal =
            math.max(evenStartMoneyTotal + amountOfMoney, oddStartMoneyTotal)
        } else {
          oddStartMoneyTotal =
            math.max(evenStartMoneyTotal, oddStartMoneyTotal + amountOfMoney)
        }
      }

      math.max(oddStartMoneyTotal, evenStartMoneyTotal)
    }
  }
}
