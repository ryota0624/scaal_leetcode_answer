object DivisorGame {
  object Solution {
    // Choosing any x with 0 < x < N and N % x == 0.
    // Replacing the number N on the chalkboard with N - x.
    def divisorGame(N: Int): Boolean = {
      N % 2 == 0
    }
  }
}
