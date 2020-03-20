object LongestPalindrome {
  def main(args: Array[String]): Unit = {
//    println("res1", perform("bbcd"))
//    println("res2", perform("babad"))
    println("res3", perform("cbbd"))
  }

  def extractLongestPalindrome(str: String, center: Int): Option[String] = {
    val oneOpt = extractLongestPalindrome(str, center - 1, center + 1)
    val twoOpt = extractLongestPalindrome(str, center, center + 1)
    (oneOpt, twoOpt) match {
      case (Some(one), Some(two)) =>
        val longest = if (one.length > two.length) one
        else if (one.length == two.length) two else two
        Some(longest)
      case (None, Some(two)) => Some(two)
      case (Some(one), None) => Some(one)
      case _ => None
    }
  }

  @scala.annotation.tailrec
  def extractLongestPalindrome(str: String, left: Int, right: Int): Option[String] = {
    val strLen = str.length
    if (strLen == right || left < 0) return Some(str.slice(left, right))

    if (str(left) == str(right)) extractLongestPalindrome(str, left - 1, right + 1)
    else if (right + left == 1) Some(str.slice(left, right))
    else None
  }

  def perform(s: String): String = {
    var longest: String = ""
    for ((_, index) <- s.zipWithIndex) {
      for (palindrome <- extractLongestPalindrome(s, index)) {
        if (palindrome.length > longest.length) {
          longest = palindrome
        }
      }
    }
    longest
  }
}
