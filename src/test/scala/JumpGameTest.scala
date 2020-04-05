import org.scalatest.FunSuite

class JumpGameTest extends FunSuite {
  test("[2,3,1,1,4] => true") {
    assert(JumpGame.canJump(Array(2, 3, 1, 1, 4)))
  }
  test("[3,2,1,0,4] => false") {
    assert(!JumpGame.canJump(Array(3, 2, 1, 0, 4)))
  }

  test("[2,0] => true") {
    assert(JumpGame.canJump(Array(2, 0)))
  }

  test("[0,2,3] => false") {
    assert(!JumpGame.canJump(Array(0, 2, 3)))
  }

  test("[0] => true") {
    assert(JumpGame.canJump(Array(0)))
  }

  test("[1,2,3] => true") {
    assert(JumpGame.canJump(Array(1,2,3)))
  }
}
