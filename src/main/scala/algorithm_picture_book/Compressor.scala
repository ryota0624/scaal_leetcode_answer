package algorithm_picture_book

trait Compressor {
  type In;
  type Out;

  def run(input: In): Out
}

class RunLengthCompressed(val value: String) extends AnyVal {}

object RunLengthCompressed {
  def apply(value: String): RunLengthCompressed = new RunLengthCompressed(value)
}

object RunLengthCompressor extends Compressor {
  override type In = String
  override type Out = RunLengthCompressed

  override def run(input: In): Out = {
    val (head, tail) = (input.head, input.tail)
    RunLengthCompressed(run(tail, head, 1))
  }

  private def run(remain: String, current: Char, countOfContinue: Int): String = {
    lazy val str = s"$current$countOfContinue"
    if (remain.isEmpty) {
      str
    } else {
      val (head, tail) = (remain.head, remain.tail)
      if (head == current) {
        run(tail, current, countOfContinue + 1)
      } else {
        str + run(tail, head, 1)
      }
    }
  }
}