

object AddBinary {
  def addBinary(a: String, b: String): String = {
    if (a.isEmpty && b.isEmpty) {
      return ""
    }

    if (a.isEmpty && b.nonEmpty) {
      return b
    }

    if (a.nonEmpty && b.isEmpty) {
      return a
    }

    val aWithoutLast = a.take(a.length - 1)
    val bWithoutLast = b.take(b.length - 1)

    (a.last, b.last) match {
      case ('1', '1') => addBinary(addBinary(aWithoutLast, bWithoutLast), "1") + "0"
      case ('0', '1') | ('1', '0') => addBinary(aWithoutLast, bWithoutLast) + "1"
      case ('0', '0') => addBinary(aWithoutLast, bWithoutLast) + "0"
      case (v) => throw new RuntimeException(s"invalid pattern $v")
    }
  }
}
