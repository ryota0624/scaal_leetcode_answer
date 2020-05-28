object MaximumNumberOfBalloons {
  private val word = "balloon"
  object Solution {
    def maxNumberOfBalloons(text: String): Int = {
      var result: Option[String] = None
      var countOfExtracted = -1
      do {
        countOfExtracted = countOfExtracted + 1
        result = extractBalloons(result.getOrElse(text))
      } while (result.isDefined)

      countOfExtracted
    }

    def extractBalloons(text: String): Option[String] = {
      var remainingText = text
      val founded = Array.fill(word.length)(false)
      word.zipWithIndex.foreach {
        case (char, wordIndex) =>
          val foundCharIndex = remainingText.indexOf(char)
          if (foundCharIndex != -1) {
            founded.update(wordIndex, true)
            remainingText = remainingText.zipWithIndex
              .filter(_._2 != foundCharIndex)
              .map(_._1)
              .mkString
          }
      }
      if (founded.contains(false)) {
        None
      } else {
        Some(remainingText)
      }
    }
  }
}
