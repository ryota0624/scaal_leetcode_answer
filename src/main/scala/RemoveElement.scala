object RemoveElement {
  def removeElement(nums: Array[Int], n: Int): Int = {
    var cursor = 0
    for (num <- nums) {
      if (n != num) {
        nums.update(cursor, num)
        cursor += 1
      }
    }
    cursor + 1
  }
}
