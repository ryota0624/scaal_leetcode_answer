object RotateArray {
  object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
      for (_ <- 0 until k) {
        rotate(nums)
      }
    }

    def rotate(nums: Array[Int]): Unit = {
      val last = nums.last
      val rotateFor = nums.length - 1
      val copied = Array.from(nums)
      for (i <- 0 until rotateFor) {
        nums.update(i + 1, copied(i))
      }
      nums.update(0, last)
    }
  }
}
