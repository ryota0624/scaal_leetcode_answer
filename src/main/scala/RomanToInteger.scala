object RomanToInteger {
  def apply(original: Seq[Int], cursor: Int, sum: Int, chunk: Seq[Int]): Int = {
    val chunkSum = (chunk: Seq[Int]) => chunk.reduceRightOption(_ - _).getOrElse(0)
    val chunkLastOpt = chunk.lastOption
    val current = original(cursor)
    println(
      Map(
        "cursor" -> cursor,
        "sum" -> sum,
        "chunk" -> chunk,
        "chunkLastOpt" -> chunkLastOpt,
        "current" -> current
      )
    )
    val currentBiggerThanChunkLast = chunkLastOpt.forall(current > _)

    val cursorReachedEnd = cursor == original.length - 1
    if (cursorReachedEnd) {
      val (s, c) = if (currentBiggerThanChunkLast) (sum, chunk :+ current)
      else (sum + current, chunk)
      return s + chunkSum(c)
    }

    val nextCursor = cursor + 1
    if (currentBiggerThanChunkLast) apply(original, nextCursor, sum, chunk :+ current)
    else {
      val nextSum = chunkSum(chunk)
      apply(original, nextCursor, nextSum, Seq(current))
    }
  }


  def apply(s: String): Int =
    apply(s.map(romanToIntegerMap(_)), 0, 0, Nil)

  val romanToIntegerMap = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000,
  )

  def main(args: Array[String]): Unit = {
    println(apply("III")) // 3
    println(apply("IV")) // 4
    println(apply("MCMXCIV")) // 1994
  }

  // 小さくなるまでchunkにつめる
}
