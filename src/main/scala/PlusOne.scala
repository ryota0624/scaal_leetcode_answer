object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    val (headOpt, tail) = plusOne_(digits)
    headOpt.toArray ++ tail
  }

  def plusOne_(digits: Array[Int]): (Option[Int], Array[Int]) = {
    if (digits.isEmpty) (None, Array(1))
    if (digits.length == 1) {
      val current = digits(0)
      val c = current + 1
      if (c == 10) {
        (Some(1), Array(0))
      } else {
        (None, Array(c))
      }
    } else {
      val (head, tail) = (digits.head, digits.tail)
      val (upOpt, tailSum) = plusOne_(tail)
      upOpt match {
        case Some(up) =>
          val current = head + up
          if (current >= 10) {
            (Some(1), Array(current % 10) ++ tailSum)
          } else {
            (None, Array(current) ++ tailSum)
          }
        case None => (None, Array(head) ++ tailSum)
      }
    }
  }
}
