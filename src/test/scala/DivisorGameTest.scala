import org.scalatest.FunSuite
import org.scalatest._

class DivisorGameTest extends FunSuite with Matchers {
  test("2 -> True") {
    DivisorGame.Solution.divisorGame(2) should be(true)
  }

  test("3 -> False") {
    DivisorGame.Solution.divisorGame(3) should be(false)
  }
}
