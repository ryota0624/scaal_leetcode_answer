object MaximizeDistanceToClosestPerson {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var leftCursor = 0
    var leftStart = leftCursor
    var rightCursor = seats.length - 1
    var rightStart = rightCursor
    var maximum = 1
    while (leftCursor < rightCursor) {
      val left = seats(leftCursor)
      val right = seats(rightCursor)

      seats.unapply(leftCursor - 1).foreach { prevSeat =>
        if (prevSeat == 1) {
          leftStart = leftCursor
        }
      }

      seats.unapply(rightCursor + 1).foreach { prevSeat =>
        if (prevSeat == 1) {
          rightStart = rightCursor
        }
      }


      if (left == 1) {
        leftCursor += 1
      }

      if (right == 1) {
        rightCursor -= 1
      }

      if (left == 1 || right == 1) {
        maximum = 0
      }
      if (left == 0 && right == 0) {

        maximum += 1
        leftCursor += 1
        rightCursor -= 1
      }
    }

    println(Map(
      "leftStart" -> leftStart,
      "rightStart" -> rightStart,
      "left" -> seats(leftStart),
      "right" -> seats(rightStart),
    ))
    rightStart - leftStart


    //    val requiredCentering = leftStart == 0 && rightStart == seats.length - 1
//    if (requiredCentering) {
//      (rightStart - leftStart) / 2
//    } else if (rightStart == seats.length - 1) {
//      rightStart
//    } else if (leftStart == 0) {
//      rightStart + 1
//    } else {
//      rightStart - leftStart
//    }
  }

  def main(args: Array[String]): Unit = {
    println(maxDistToClosest(Array(1, 0, 0, 0, 1, 0, 1))) // 2
    println("-----------------------")
    println(maxDistToClosest(Array(1, 0, 0, 0))) // 3
    println("-----------------------")
    println(maxDistToClosest(Array(0, 0, 1))) // 2
    println("-----------------------")
    println(maxDistToClosest(Array(1, 0, 1))) // 1
    println("-----------------------")
    println(maxDistToClosest(Array(0, 1))) // 1
    println("-----------------------")
    println(maxDistToClosest(Array(1, 1, 0, 1, 1))) // 1
  }
}
