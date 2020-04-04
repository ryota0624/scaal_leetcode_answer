import org.scalatest.FunSuite

class ClimbStairsTest  extends FunSuite {
  test("3") {
    assert(ClimbStairs.climbStairs(3) == 3)
  }

  test("1") {
    assert(ClimbStairs.climbStairs(1) == 1)
  }

  test("0") {
    assert(ClimbStairs.climbStairs(1) == 1)
  }

  test("42") {
    assert(ClimbStairs.climbStairs(42) == 433494437)
  }
}

