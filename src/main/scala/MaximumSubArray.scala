object MaximumSubArray {
  def maxSubArray(nums: Array[Int]): Int = {
    var cursor = 0
    val numsLen = nums.length
    var maximum = nums.head
    while (cursor < numsLen) {
      var cursor2 = 0
      while (cursor2 + cursor < numsLen) {
        val sum = nums.slice(cursor, cursor + cursor2 + 1).sum
        maximum = Math.max(sum, maximum)
        cursor2 += 1
      }
      cursor += 1
    }
    maximum
  }

}
