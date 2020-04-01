package algorithm_picture_book

trait Decompressor {
  type In;
  type Out;

  def run(input: In): Out
}

object RunLengthDecompressor extends Decompressor {
  override type In = RunLengthCompressed
  override type Out = String

  override def run(input: In): Out = {
    runRecursive(input.value)
  }

  def runRecursive(remain: String): String = {
    if (remain.isEmpty) {
      return ""
    }

    if (remain.length < 2) {
      throw new RuntimeException("remain length < 2")
    }

    val (pair, tail) = remain.splitAt(2)
    val (char, countStr) = pair.splitAt(1)
    val count = countStr.toIntOption.getOrElse[Int] {
      throw new RuntimeException("invalid run length compression format")
    }

    List.fill(count)(char).mkString + runRecursive(tail)
  }
}