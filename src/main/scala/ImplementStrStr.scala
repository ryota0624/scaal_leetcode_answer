object ImplementStrStr {
  def strStr(haystack: String, needle: String): Int = {
    if (needle.isEmpty) return 0
    for ((_, i) <- haystack.zipWithIndex) {
      val t = haystack.slice(i, i + needle.length)
      if (t == needle) {
        return i
      }
    }

    -1
  }

  def main(args: Array[String]): Unit = {
    println(strStr("hello", "ll"))
  }
}
