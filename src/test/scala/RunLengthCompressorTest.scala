import algorithm_picture_book.{RunLengthCompressed, RunLengthDecompressor, RunLengthCompressor}
import org.scalatest.FunSuite

class RunLengthCompressorTest extends FunSuite {
  test("run length compression") {
    assert(RunLengthCompressor.run("fffaeifssiii") == RunLengthCompressed("f3a1e1i1f1s2i3"))
  }

  test("run length compression decompression") {
    assert(RunLengthDecompressor.run(RunLengthCompressed("f3a1e1i1f1s2i3")) == "fffaeifssiii")
  }

  test("run length compression <-> decompression") {
    val input = "f3a1e1i1f1s2i3"
    val compressed = RunLengthCompressor.run(input)
    val decompressed = RunLengthDecompressor.run(compressed)
    assert(input == decompressed)
  }

  // TODO: RunLengthDecompressor の異常系
}
