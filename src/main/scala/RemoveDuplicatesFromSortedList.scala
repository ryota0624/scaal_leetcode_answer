import utils.ListNode

object RemoveDuplicatesFromSortedList {
  implicit class ListNodeEx(n: ListNode) {
    def removeDuplicate():ListNode = {
      if (n.isLast) {
        n
      } else {
        val duplicateRemovedTail = n.next.removeDuplicate()
        if (n.next.x == n.x) {
          duplicateRemovedTail
        } else {
          ListNode(n.x, duplicateRemovedTail)
        }
      }
    }

    def hasNext: Boolean = n.next != null
    def isLast: Boolean = !hasNext

  }
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head != null )head.removeDuplicate() else null
  }
}
