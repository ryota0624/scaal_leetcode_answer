object RangeSumQuery {
  class NumArray(_nums: Array[Int]) {
    def sumRange(i: Int, j: Int): Int = {
      val range = _nums.take(j + 1).takeRight(j - i + 1)
      range.sum
    }
  }
}
