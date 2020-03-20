import scala.collection.mutable

object ZigZagConversion {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) s else view(convertToSeq(s, numRows))
  }

  def convertToSeq(s: String, numRows: Int): mutable.Seq[mutable.Seq[Option[Char]]] = {
    val container = mutable.ArraySeq.from((0 until numRows).map(_ => mutable.Seq.empty[Option[Char]]))
    val containerSize = container.size
    var reverse = false
    var progress = 0
    val turnReverseCount = containerSize - 2
    var reverseCount = turnReverseCount

    for (char <- s) {
      if (!reverse) {
        var line = container(progress)
        line :+= Some(char)
        container.update(progress, line)
        progress = progress + 1
        if (progress == containerSize) {
          if (turnReverseCount > 0) {
            reverse = true
            reverseCount = turnReverseCount
          }
          progress = 0
        }
      } else {
        for (i2 <- 0 until containerSize) {
          val reverseCursor = (containerSize - 1) - i2
          var line = container(reverseCursor)
          line :+= (if (reverseCursor == reverseCount) Some(char) else None)
          container.update(reverseCursor, line)
        }

        reverseCount = reverseCount - 1
        if (reverseCount == 0) {
          reverse = false
        }
      }
    }
    container
  }

  def view(seq: mutable.Seq[mutable.Seq[Option[Char]]]): String =
  //    seq.map(_.flatten.mkString).mkString
    seq.map(_.map(_.getOrElse(' ')).mkString).mkString("\n")


  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 4))
    println("---------------")
    println(convert("PAYPALISHIRING", 3))
    println("---------------")
    println(convert("PAYPALISHIRING", 2))
    println("---------------")
    println(convert("PAYPALISHIRING", 1))
    println("---------------")
    println(convert("ABC", 2))
    println("---------------")
    println(convert("ABCD", 2))
  }
}
