object MaximumSubArray {
  def maxSubArray(nums: Array[Int]): Int = {
    val numsLen = nums.length
    var maximum = nums.head

    var cursor = 0
    while (cursor < numsLen) {
      var cursor2 = 0
      while (cursor2 + cursor < numsLen) {
        var sum = nums(cursor)
        var memo = scala.collection.mutable.ArrayBuffer.empty[Int]
        var i = cursor + 1
        while (i < cursor + cursor2 + 1) {
          sum = sum + nums(i)
          i += 1
        }
        maximum = Math.max(sum, maximum)
        cursor2 += 1
      }
      cursor += 1
    }
    maximum
  }

}
