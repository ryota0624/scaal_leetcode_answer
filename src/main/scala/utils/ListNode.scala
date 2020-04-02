package utils


class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  override def toString: String = {
    val tailStr = if (next == null) "" else s" -> ${next.toString}"
    s"${_x}${tailStr}"
  }

  def toSeq(): Seq[Int] = {
    if (next == null) {
      _x :: Nil
    } else {
      Seq(_x) ++ next.toSeq()
    }
  }
}

object ListNode {
  def apply(_x: Int, next: ListNode): ListNode = {
    val l = new ListNode(_x)
    l.next = next
    l
  }

  def apply(_x: Int): ListNode = new ListNode(_x)

  def apply(seq: Seq[Int]): ListNode = {
    if (seq.isEmpty) return null
    val head = seq.head
    ListNode(head, apply(seq.tail))
  }
}