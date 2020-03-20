object SearchInRotatedSortedArray {
  def search(nums: Array[Int], target: Int): Int = {
    var i = 0
    val len = nums.length
    while (i != len) {
      if (nums(i) == target) {
        return i
      }
      i += 1
    }

    -1
  }
}
