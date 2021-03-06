import org.scalatest.FunSuite

class MajorityElementTest extends FunSuite {
  test("3,2,3 -> 3") {
    assert(MajorityElement.Solution.majorityElement(Array(3, 2, 3)) == 3)
  }

  test("2,2,1,1,1,2,2 -> 2") {
    assert(
      MajorityElement.Solution.majorityElement(Array(2, 2, 1, 1, 1, 2, 2)) == 2
    )
  }
}
