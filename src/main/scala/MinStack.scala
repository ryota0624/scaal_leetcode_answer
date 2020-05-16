object MinStack {

  class MinStack() {

    var min: Int = Int.MaxValue

    var stack = List.empty[Int]

    def push(x: Int) {
      stack = stack :+ x

      min = stack.min
    }

    def pop() {
      stack = stack.take(stack.length - 1)
      if (stack.nonEmpty) {
        min = stack.min
      }
    }

    def top(): Int = {
      stack.last
    }

    def getMin(): Int = min
  }


  def processCommand(cmd: String, arg: AnyVal, minStack: MinStack): Any = {
    val result = cmd match {
      case "pop" => minStack.pop()
        null
      case "getMin" => minStack.getMin()
      case "push" => minStack.push(arg.asInstanceOf[Int])
        null
      case "top" => minStack.top()
    }

    println(cmd, arg, result)
    result
  }

  def processCommands(cmds: Seq[String], args: Seq[AnyVal]): Seq[Any] = {
    var result = Seq.empty[Any]
    val minStack = new MinStack()
    for ((cmd, i) <- cmds.zipWithIndex) {
      val arg = args(i)
      result = result :+ processCommand(cmd, arg, minStack)
    }

    result
  }
}
