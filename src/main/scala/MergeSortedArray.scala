object MergeSortedArray {

  import scala.util._
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    val num1Copied = Array.from(nums1).take(m)
    var num1Cursor = 0
    var num2Cursor = 0
    var cursor = 0
    val nums2Use = nums2.take(n)

    while (cursor <= m + n) {
      val n1T =
        Try {
          num1Copied(num1Cursor)
        }
      val n2T = Try {
        nums2Use(num2Cursor)
      }
      val smaller = (n1T, n2T) match {
        case (Success(n1), Success(n2)) =>
          if (n1 > n2) {
            num2Cursor += 1
            n2
          } else {
            num1Cursor += 1
            n1
          }
        case (_, Success(n2)) =>
          num2Cursor += 1
          n2
        case (Success(n1), _) =>
          num1Cursor += 1
          n1
        case (Failure(_), Failure(_)) =>
          println(nums1)
          throw new RuntimeException()
      }

      nums1.update(cursor, smaller)
      cursor += 1
    }
  }

}
