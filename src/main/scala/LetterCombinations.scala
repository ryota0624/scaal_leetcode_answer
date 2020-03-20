object LetterCombinations {
  def letterCombinations(digits: String): List[String] = {
    digits.headOption match {
      case Some(head) => letterCombinations(head, digits.tail)
      case None => Nil
    }
  }

  def letterCombinations(head: Char, tail: String): List[String] = {
    val variation = phoneButtonMapping(head)
    val nextHeadOpt = tail.headOption
    nextHeadOpt match {
      case Some(nextHead) =>
        val nextTail = tail.tail
        val patterns = for (c <- variation) yield {
          val tailVariations = letterCombinations(nextHead, nextTail)
          val str = c.toString().asInstanceOf[String]
          tailVariations.map(tailVariation => str + tailVariation)
        }
        patterns.flatten.toList
      case None =>
        variation.map(_.toString().asInstanceOf[String]).toList
    }

  }

  val phoneButtonMapping = Map(
    '2' -> Set('a', 'b', 'c'),
    '3' -> Set('d', 'e', 'f'),
    '4' -> Set('g', 'h', 'i'),
    '5' -> Set('j', 'k', 'l'),
    '6' -> Set('m', 'n', 'o'),
    '7' -> Set('p', 'q', 'r', 's'),
    '8' -> Set('t', 'u', 'v'),
    '9' -> Set('w', 'x', 'y', 'z'),
  )

  def main(args: Array[String]): Unit = {
    println(letterCombinations("23"))
  }

}
