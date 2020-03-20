object RemoveNthNodeFromEndOfList {

  import utils._

  implicit class ListNodeExt(l: ListNode) {
    def indexOf(i: Int): ListNode = {
      if (i == 0) l
      else {
        if (l.next == null) throw null
        else l.next.indexOf(i - 1)
      }
    }

    def length: Int = {
      if (l.next == null) {
        return 1
      }
      l.next.length + 1
    }

    def hasNext: Boolean = l.next != null

    def replaceNext(replace: ListNode): Unit = {
      l.next = replace
    }

    def removeNext(): Unit = {
      l.next = null
    }

    def removeOnlyNext(): Unit = {
      val next = l.next
      if (next.hasNext) {
        replaceNext(next.next)
      } else {
        removeNext()
      }
    }
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val removeIndex = head.length - n
    val tmpRoot = ListNode(0, head)
    tmpRoot.indexOf(removeIndex).removeOnlyNext()
    tmpRoot.next
  }

  def main(args: Array[String]): Unit = {
    val n = utils.ListNode(Seq(1, 2))
    println(removeNthFromEnd(n, 2))
  }

}





