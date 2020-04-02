import org.scalatest.FunSuite
import utils.ListNode

class RemoveDuplicatesFromSortedListTest extends FunSuite {
  test("正常系") {
    val listNode = ListNode(Seq(1, 1, 2, 3, 3, 4, 5))
    val duplicateRemoved = RemoveDuplicatesFromSortedList.deleteDuplicates(listNode)
    assert(duplicateRemoved.toSeq() == Seq(1,2,3,4,5))
  }
}


