import org.scalatest.FunSuite

class MaximumSubArrayTest extends FunSuite {
  test("simple") {
    val arr = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    assert(MaximumSubArray.maxSubArray(arr) == 6)
  }

  test("subarray") {
    assert(MaximumSubArray.maxSubArray(Array(-2, 1)) == 1)
  }
}
