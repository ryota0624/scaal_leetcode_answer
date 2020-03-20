object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int = {
    var max = 0
    val heightWithIndex = height.zipWithIndex
    val len = height.length
    for ((value, widthLeft) <- heightWithIndex) {
      for ((value2, widthRight) <- heightWithIndex.takeRight(len - widthLeft)) {
        if (widthRight > widthLeft) {
          val height = math.min(value, value2)
          val width = widthRight - widthLeft
          val waterCap = height * width
          if (waterCap > max) {
            max = waterCap
          }
        }
      }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea(Array(1, 1)))

  }
}
