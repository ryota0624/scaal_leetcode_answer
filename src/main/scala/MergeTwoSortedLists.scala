object MergeTwoSortedLists {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  object ListNode {
    def apply(_x: Int, next: ListNode): ListNode = {
      val l = new ListNode(_x)
      l.next = next
      l
    }
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null && l2 == null) {
      return null
    }

    if (l1 == null) {
      return l2
    }

    if (l2 == null) {
      return l1
    }

    val (bigger, smaller) = if (l1.x > l2.x)
      (l1, l2)
    else (l2, l1)

    val next = if (smaller.next != null)
      mergeTwoLists(smaller.next, bigger)
    else bigger
    ListNode(smaller.x, next)
  }
}
