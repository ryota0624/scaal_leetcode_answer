object StringToInteger {
  def myAtoi(str: String): Int = {
    val nString = extractNumberString(str)
    val number = nString.flatMap(_.toFloatOption).getOrElse[Float](0)
    number match {
      case _ if number > Int.MaxValue => Int.MaxValue
      case _ if number < Int.MinValue => Int.MinValue
      case _ => number.toInt
    }
  }

  def extractNumberString(str: String): Option[String] = {
    val numberChars: Seq[Char] = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).map(_.toString().asInstanceOf[String].head)
    val minusSign = '-'
    val plusSign = '+'
    val dotSign = '.'
    val whiteSpace = ' '
    val allowedSigns = Nil :+ minusSign :+ plusSign
    val firstAllowedChars = (((numberChars :+ minusSign) :+ whiteSpace) :+ dotSign) :+ plusSign
    var chunk: Seq[Char] = Seq.empty
    for (char <- str) {
      if (!firstAllowedChars.exists(_.equals(char))) {
        return None
      }

      val charIsNumber = numberChars.exists(_.equals(char))
      if (charIsNumber) {
        chunk = chunk :+ char
      }

      if (chunk.nonEmpty && !charIsNumber) {
        return Some(chunk.mkString)
      }

      if (chunk.isEmpty && (char == minusSign  || char == plusSign || char == dotSign)) {
        chunk = chunk :+ char
      }
    }

    if (chunk.nonEmpty) {
      Some(chunk.mkString)
    } else {
      None
    }
  }

  def main(args: Array[String]): Unit = {
    println(extractNumberString("   -42"))
    println(extractNumberString("4193 with words"))
    println(extractNumberString("words and 987"))
    println(extractNumberString("3.14159"))
    println(extractNumberString("+-2"))
  }
}
