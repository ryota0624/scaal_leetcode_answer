object RemoveDuplicatesFromSortedArray {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    var cursor = 1
    var hold = nums.head
    for (num <- nums.tail) {
      if (num != hold) {
        nums.update(cursor, num)
        hold = num
        cursor += 1
      }
    }
    cursor
  }

  //  def removeDuplicates(nums: Array[Int], sum: Int): Int = {
  //    if (nums.isEmpty) return sum
  //    val head = nums.head
  //    val tail = nums.tail
  //    var i = 0
  //    for (inTail <- tail) {
  //      if (inTail != head) {
  //        return removeDuplicates(tail.takeRight(tail.length - i), sum + 1)
  //      }
  //      i += 1
  //    }
  //    sum + 1
  //  }

  def main(args: Array[String]): Unit = {
    var array = Array(1, 1, 2)
    (removeDuplicates(array))
    println(array.mkString(","))
  }
}
