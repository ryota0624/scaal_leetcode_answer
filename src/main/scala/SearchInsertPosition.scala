object SearchInsertPosition {
  def search(nums: Array[Int], target: Int): Int = {
    var i = 0
    val len = nums.length
    while (i != len) {
      val n = nums(i)
      if (n == target) {
        return i
      } else if (n > target) {
        return i - 1
      }
      i += 1
    }

    len + 1
  }
}
