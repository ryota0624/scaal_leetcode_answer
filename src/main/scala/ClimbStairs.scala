
object ClimbStairs {
  import scala.collection.mutable

  def climbStairs(n: Int): Int = {
   climbStairsWithMemo(n, mutable.ArrayBuffer.empty)._1
  }

  def climbStairsWithMemo(n: Int, memo: mutable.ArrayBuffer[Int]): (Int, mutable.ArrayBuffer[Int]) = {
    n match {
      case 0 | 1 =>
        (1, mutable.ArrayBuffer(1, 1))
      case _ =>
        val (prevResult, resultMemo) = climbStairsWithMemo(n - 1, memo)
        val result = prevResult + resultMemo(n - 2)
        resultMemo += result
        (result, resultMemo)
    }
  }
}
