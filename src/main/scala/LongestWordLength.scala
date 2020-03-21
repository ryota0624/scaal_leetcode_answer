object LongestWordLength {
  def lengthOfLastWord(s: String): Int = {
    if (s.isEmpty) return 0
    val split = s.split(" ")
    if (split.isEmpty) 0
    else split.maxBy(_.length).length
  }

  def search(s: String): Int = {
    var longest = ""
    var hold = Seq.empty[Char]

    for (char <- s) {
      if (char.toInt >= 65 && char.toInt <= 90) {
        hold = Seq.empty
      }

      if (char != ' ') {
        hold = hold :+ char
        if (hold.length > longest.length) {
          longest = hold.mkString
        }
      } else {
        hold = Seq.empty
      }
    }


    longest.length
  }
}
