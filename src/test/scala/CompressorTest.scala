import algorithm_picture_book.{RunLengthCompressionDecompressor, RunLengthCompressor}
import org.scalatest.FunSuite

class CompressorTest extends FunSuite {
  test("run length compression") {
    assert(RunLengthCompressor.run("fffaeifssiii") == "f3a1e1i1f1s2i3")
  }
}

class DecompressorTest extends FunSuite {
  test("run length compression decompression") {
    assert(RunLengthCompressionDecompressor.run("f3a1e1i1f1s2i3") == "fffaeifssiii")
  }
}