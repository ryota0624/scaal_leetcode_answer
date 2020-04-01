package algorithm_picture_book

trait Compressor {
  type In;
  type Out;

  def run(input: In): Out
}

object RunLengthCompressor extends Compressor {
  override type In = String
  override type Out = String

  override def run(input: String): String = {
    val (head, tail) = (input.head, input.tail)
    run(tail, head, 1)
  }

  private def run(remain: String, current: Char, countOfContinue: Int): String = {
    if (remain.isEmpty) {
      s"$current$countOfContinue"
    } else {
      val (head, tail) = (remain.head, remain.tail)
      if (head == current) {
        run(tail, current, countOfContinue + 1)
      } else {
        s"$current$countOfContinue" + run(tail, head, 1)
      }

    }
  }
}