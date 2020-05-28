import org.scalatest.{FunSuite, Matchers}

class MaximumNumberOfBalloonsTest extends FunSuite with Matchers {
  test("nlaebolko -> 1") {
    MaximumNumberOfBalloons.Solution.maxNumberOfBalloons("nlaebolko") shouldEqual (1)
  }

  test("loonbalxballpoon -> 2") {
    MaximumNumberOfBalloons.Solution.maxNumberOfBalloons("loonbalxballpoon") shouldEqual (2)
  }

  test("scal -> 0") {
    MaximumNumberOfBalloons.Solution.maxNumberOfBalloons("scal") shouldEqual (0)
  }

  test("extractBalloons") {
    MaximumNumberOfBalloons.Solution.extractBalloons("nlaebolko") shouldEqual Some(
      "ek"
    )
    MaximumNumberOfBalloons.Solution.extractBalloons("loonbalxballpoon") shouldEqual Some(
      "xballpoon"
    )
    MaximumNumberOfBalloons.Solution.extractBalloons("scal") shouldEqual None

  }
}
