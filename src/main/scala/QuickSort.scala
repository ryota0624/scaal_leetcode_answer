//import scala.util.Random
//import scala.math.Ordered._
//
//
//object QuickSort {
//  //  implicit val intOrdered: Ordered[Int] = Ordering.fromLessThan(_ > _)
//
//  def main(args: Array[String]): Unit = {
//    val input: Seq[Int] = (1 to 10).map { _ => Random.nextInt() / 100 }
//    println(input)
//    val sorted = sort(input)
//    println(sorted)
//  }
//
//
//  def sort[T <: Ordered[T]](seq: Iterable[T]): Iterable[T] = {
//    if (seq.isEmpty) return seq
//    val pivot = seq.head
//    val (left, right) = seq.tail.foldLeft[(Seq[T], Seq[T])](Nil, Nil) { case ((left, right), item) =>
//      if (item > pivot) (left, right :+ item) else (left :+ item, right)
//    }
//
//    val sortedLeft = sort(left)
//    val sortedRight = sort(right)
//    sortedLeft ++ (pivot :: Nil) ++ sortedRight
//  }
//}
