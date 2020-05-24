import org.scalatest.{FunSuite, Matchers}

class IsSubsequenceTest extends FunSuite with Matchers {
  test("s = \"abc\", t = \"ahbgdc\" -> true") {
    IsSubsequence.Solution.isSubsequence("abc", "ahbgdc") shouldEqual true
  }

  test("s = \"axc\", t = \"ahbgdc\" -> false") {
    IsSubsequence.Solution.isSubsequence("axc", "ahbgdc") shouldEqual false
  }

  test("s = \"aaaaaa\", t = \"bbaaaa\" -> false") {
    IsSubsequence.Solution.isSubsequence("aaaaaa", "bbaaaa") shouldEqual false
  }
}
