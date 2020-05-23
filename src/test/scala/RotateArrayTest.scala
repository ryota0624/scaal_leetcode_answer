import org.scalatest.FunSuite

class RotateArrayTest extends FunSuite {
  test("nums = [1,2,3,4,5,6,7], k = 3 -> [5,6,7,1,2,3,4]") {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    RotateArray.Solution.rotate(array, 3)
    assert(array.mkString(",") == Array(5, 6, 7, 1, 2, 3, 4).mkString(","))
  }

}
