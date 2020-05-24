import org.scalatest.{FunSuite, Matchers}

class RangeSumQueryTest extends FunSuite with Matchers {
  val array = new RangeSumQuery.NumArray(Array(-2, 0, 3, -5, 2, -1))
  test("sumRange(0, 2) -> 1") {
    array.sumRange(0, 2) shouldEqual 1
  }

  test("sumRange(2, 5) -> -1") {
    array.sumRange(2, 5) shouldEqual -1

  }
  test("sumRange(0, 5) -> -3") {
    array.sumRange(0, 5) shouldEqual -3

  }

}
