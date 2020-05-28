object MatrixBlockSum {
  object Solution {
    def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
      val height = mat.length
      val width = mat.head.length
      for (i <- 0 until height) yield {
        val seq = for (j <- 0 until width) yield {
          var sum = 0
          for (r <- i - K to i + K) {
            for (c <- j - K to j + K) {
              if (r >= 0 && r < height && c >= 0 && c < width) {
                sum = sum + mat(r)(c)
              }
            }
          }
          sum
        }
        seq.toArray
      }
    }.toArray
  }
}

/**
  *
  * object MatrixBlockSum {
  * object Solution {
  * def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
  * val height = mat.length
  * val width = mat.head.length
  * val result = Array.fill(height)(Array.fill(width)(0))
  * val dp = Array.fill(height + 1)(Array.fill(width + 1)(0))
  * for (i <- 0 to height) {
  * val seq = for (j <- 0 to width) yield {
  * var sum = 0
  * dp(i).update(
  * j,
  * dp(i)(j + 1) + dp(i + 1)(j) + mat(i)(j) - dp(i)(j)
  * )
  *
  * //          for (r <- i - K to i + K) {
  * //            for (c <- j - K to j + K) {
  * //              if (r >= 0 && r < height && c >= 0 && c < width) {
  * //                sum = sum + mat(r)(c)
  * //              }
  * //            }
  * //          }
  * sum
  * }
  *         result.update(i, seq.toArray)
  * }
  * result
  * }
  * }
  * }
  */
