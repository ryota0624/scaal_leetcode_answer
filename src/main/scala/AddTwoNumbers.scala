/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 * var next: ListNode = null
 * var x: Int = _x
 * }
 */


object AddTwoNumbers {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  case object ZeroListNode extends ListNode(0)

  object ListNode {
    def apply(_x: Int, next: ListNode): ListNode = {
      val n = new ListNode(_x)
      n.next = next
      n
    }

    def endNode: ListNode = null
  }

  implicit class ListNodeExt(l: ListNode) {
    def nextOpt: Option[ListNode] = Option.apply(l.next)

    def addInt(n: Int): ListNode = {
      ListNode.apply(n + l.x, l.next)
    }

    def hasNext: Boolean = nextOpt.isDefined

    def nextOrZero: ListNode = nextOpt.getOrElse(ZeroListNode)

    private def add(other: ListNode, append: Int): ListNode = {
      val nodeSum = l.x + other.x + append
      if (nodeSum == 0 && (!hasNext && !other.hasNext)) return ListNode.endNode

      val nodeVal = nodeSum % 10
      val appendToNext = nodeSum / 10
      ListNode.apply(nodeVal, (l.nextOrZero.add(other.nextOrZero, appendToNext)))
    }

    def add(other: ListNode): ListNode = {
      val r = add(other, 0)
      if (r != ListNode.endNode) r
      else ZeroListNode
    }
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = l1.add(l2) //addNode(l1, l2)
}