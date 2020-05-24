object IsSubsequence {
  object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
      if (s.isEmpty) return true
      val foundOpt = indexOf(s.head, t)
      foundOpt match {
        case Some(foundIndex) =>
          val remaining = t.substring(foundIndex + 1, t.length)
          if (remaining.length < s.tail.length) {
            false
          } else {
            isSubsequence(s.tail, remaining)
          }
        case None =>
          false
      }
    }
    def indexOf(c: Char, t: String): Option[Int] = {
      val i = t.indexOf(c)
      if (i == -1) None
      else Some(i)
    }
  }
}
