import org.scalatest.FunSuite

class ClimbStairsTest  extends FunSuite {
  import MinStack._
  test("push -2 -> -0 -> -3") {
    val minStack = new MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    assert(minStack.getMin() == -3)
    minStack.pop()
    assert(minStack.top() == 0)
    assert(minStack.getMin() == -2)
  }

  test("push big number") {
    val minStack = new MinStack()
    minStack.push(2147483646)
    minStack.push(2147483646)
    minStack.push(2147483647)
    minStack.push(2147483647)
    minStack.push(-2147483648)
  }

  test("big number") {
    val commands = Seq("push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin")
    val args = Seq((2147483646),(2147483646),(2147483647),(),(),(),(),(),(),(2147483647),(),(),(-2147483648),(),(),(),())
    val expect = Seq(null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647)

    val result = processCommands(commands, args)
    assert(result == expect)
  }
}

