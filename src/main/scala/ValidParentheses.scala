object ValidParentheses {
  def isValid(s: String): Boolean = {
    val headOpt = s.headOption
    headOpt match {
      case Some(head) =>
        if (closeBrackets.contains(head)) false
        else isValid(Seq(head), s.tail)
      case None => true
    }
  }

  def isValid(ctx: Seq[Char], remaining: String): Boolean = {
    if (remaining.isEmpty) {
      if (ctx.isEmpty) {
        return true
      } else {
        return false
      }
    }
    val remainingHead = remaining.head
    val ctxHeadOpt = ctx.headOption
    ctxHeadOpt match {
      case Some(ctxHead) =>
        if (isPair(ctxHead, remainingHead))
          isValid(ctx.tail, remaining.tail) // 正しく閉じられるパターン
        else if (openBrackets.contains(remainingHead) && remaining.nonEmpty)
          isValid(Seq(remainingHead) ++ ctx, remaining.tail) // 新しくひらかれた時
        else if (closeBrackets.contains(remainingHead)) { // コンテキストで指定されたもの以外で閉じられている
          false
        }
        else false
      case None =>
        println("ctxHead is None")
        isValid(Seq(remainingHead), remaining.tail)
    }
  }

  def isPair(c: Char, c1: Char) =
    openBrackets.indexOf(c) == closeBrackets.indexOf(c1)


  val openBrackets = Seq('(', '[', '{')
  val closeBrackets = Seq(')', ']', '}')

  def main(args: Array[String]): Unit = {
    println(isValid("){"))
    //    println(isValid("{()}"))
    //    println(isValid("{}()"))
    //    println(isValid("{("))

  }

}
