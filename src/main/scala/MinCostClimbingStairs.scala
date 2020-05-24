object MinCostClimbingStairs {
  object Solution {
    def minCostClimbingStairs(cost: Array[Int]): Int = {
      if (cost.isEmpty) return 0
      if (cost.length == 1) return cost.head
      if (cost.length == 2) return (math.max(cost.head, cost(1)))

      var dpTable = Array.from(cost.take(2))
      for (i <- 0 until cost.length - 2) {
        val index = i + 2
        val c = cost(index)
        dpTable = dpTable :+ math.min(
          dpTable(index - 1) + c,
          dpTable(index - 2) + c
        )
      }

      math.min(dpTable(cost.length - 1), dpTable(cost.length - 2))
    }
  }
}
