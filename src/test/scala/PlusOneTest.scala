import org.scalatest.FunSuite

class PlusOneTest extends FunSuite {
  test("上げがない場合") {
    assert(PlusOne.plusOne(Array(1, 2, 3)).mkString == Array(1, 2, 4).mkString)
  }

  test("上げがある場合") {
    assert(PlusOne.plusOne(Array(1, 2, 9)).mkString == Array(1, 3, 0).mkString)
  }

  test("上がった値からさらに上がる場合") {
    assert(PlusOne.plusOne(Array(1, 9, 9)).mkString == Array(2, 0, 0).mkString)
  }
}
