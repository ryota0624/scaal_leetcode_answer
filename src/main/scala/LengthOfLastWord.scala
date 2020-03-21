object LengthOfLastWord {
  def lengthOfLastWord(s: String): Int = {
    if (s.isEmpty) return 0
    s.split(" ").lastOption.map(_.length).getOrElse(0)
  }
}
