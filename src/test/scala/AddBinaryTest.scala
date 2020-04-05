import org.scalatest.FunSuite

class AddBinaryTest extends FunSuite {
  test("simple") {
    assert(AddBinary.addBinary("0", "0") == "0")
    assert(AddBinary.addBinary("1", "0") == "1")
    assert(AddBinary.addBinary("0", "1") == "1")
    assert(AddBinary.addBinary("1", "1") == "10")

  }

  test("空文字は0") {
    assert(AddBinary.addBinary("0", "0") == "0")
  }

  test("片方がからならもう片方がそのまま返る") {
    assert(AddBinary.addBinary("101", "") == "101")
    assert(AddBinary.addBinary("", "1") == "1")
  }

  test("繰り上がりが発生しない") {
    assert(AddBinary.addBinary("101", "10") == "111")
  }

  test("繰り上がりが発生する") {
    assert(AddBinary.addBinary("101", "11") == "1000")
    assert(AddBinary.addBinary("111", "11") == "1010")
  }

}
