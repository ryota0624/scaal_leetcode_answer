object IsPalindrome {
  def apply(x: Int): Boolean = {
    val str = x.toString().asInstanceOf[String]
    val len = str.length
    for (cursor <- (0 until len)) {
      println(cursor, len - cursor, len)
      val back = str(len - cursor - 1)
      if (str(cursor) != back) {
        return false
      }
    }
    return true
  }
}
