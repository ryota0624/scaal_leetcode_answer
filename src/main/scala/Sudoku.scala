
object Sudoku {

  case class Board(sections: Seq[Section]) {
    assert(sections.length == 9)

    def indexOf(i: Int): Section = {
      if (i < 0 || i > 9) throw new IndexOutOfBoundsException
      sections(i)
    }

    def verticalIndexOf(vertical: Int): Line = {
      val sectionIndex = vertical / 3
      val sections = crossSections.map(_ (vertical))
      Line(sections.flatMap(_.verticalIndexOf(sectionIndex)))
    }

    def crossIndexOf(cross: Int): Line = {
      val sectionIndex = cross / 3
      val sections = crossSections(sectionIndex)
      Line(sections.flatMap(_.crossIndexOf(sectionIndex)))
    }

    private def crossSections: Seq[Seq[Section]] =
      sections.grouped(3).toSeq

    /**
     * [[1], [2], [3], [4], [5], [6], [7], [8], [9]]
     *
     * to
     *
     * [[1], [2], [3]],
     * [[4], [5], [6]],
     * [[7], [8], [9]],
     *
     **/

  }

  object Board {
    def charMapping = Map(
      '1' -> 1,
      '2' -> 2,
      '3' -> 3,
      '4' -> 4,
      '5' -> 5,
      '6' -> 6,
      '7' -> 7,
      '8' -> 8,
      '9' -> 9
    )

    def apply(board: Array[Array[Char]]): Board = {
      // sectionごとのseqに並び替える
//      val groupedBoard = board.grouped(3)

      val boardArray = Array.empty[Array[Char]]

      for ((line, i) <- board.zipWithIndex) {
        for ((char, j) <- line.zipWithIndex) {
        }
//        val groupedLine = line.grouped(3)
//        val sectionIndex = i / 3

        /**
         * [
         * ["5","3",".",".","7",".",".",".","."],
         * ["6",".",".","1","9","5",".",".","."],
         * [".","9","8",".",".",".",".","6","."],
         * ["8",".",".",".","6",".",".",".","3"],
         * ["4",".",".","8",".","3",".",".","1"],
         * ["7",".",".",".","2",".",".",".","6"],
         * [".","6",".",".",".",".","2","8","."],
         * [".",".",".","4","1","9",".",".","5"],
         * [".",".",".",".","8",".",".","7","9"]
         * ]
         *
         * to
         * [
         * [["5","3","."],[".","7","."],[".",".","."]],
         * ...
         * ]
         */
      }
    }

    def apply(sections: Seq[Section]): Board = new Board(sections)
  }

  class Number(n: Option[Int]) {
    n.foreach(num => assert(num > 0 && num < 10))

    def isEmpty: Boolean = n.isEmpty

    def isDefined: Boolean = n.isDefined

    def valueOf: Option[Int] = n

  }

  object Number {
    def apply(n: Int): Number = new Number(Some(n))

    val none: Number = new Number(None)

  }

  class Numbers(val values: Seq[Number]) {
    assert(values.length == 9)

    def indexOf(i: Int): Number = values(i)

    def hasDuplicated: Boolean = {
      val numbers = values.flatMap(_.valueOf)
      values.length != numbers.toSet.size
    }

    def IsAllDefined: Boolean = {
      values.count(_.isDefined) == 9
    }
  }

  object Numbers {
    def apply(values: Seq[Number]): Numbers = new Numbers(values)
  }

  trait Validatable {
    def numbers: Numbers

    def isCorrect(): Boolean = numbers.IsAllDefined && !numbers.hasDuplicated

    def isCorrectPartially(): Boolean = !numbers.hasDuplicated

    def isInvalid(): Boolean = numbers.hasDuplicated
  }

  case class Section(numbers: Numbers) extends Validatable {
    def crossLines(): Seq[Line] = {
      val numbers = for (i <- 0 to 3) yield {
        crossIndexOf(i)
      }

      numbers.map(Line.apply)
    }

    def verticalLines(): Seq[Line] = {
      val numbers = for (i <- 0 to 3) yield {
        verticalIndexOf(i)
      }

      numbers.map(Line.apply)
    }


    def verticalIndexOf(i: Int): Seq[Number] = {
      if (i > 2 || i < 0) throw new IndexOutOfBoundsException
      val numbers = for (numbers <- crossVertically) yield {
        numbers(i)
      }

      assert(numbers.length == 3)
      numbers
    }

    def crossIndexOf(i: Int): Seq[Number] = {
      if (i > 2 || i < 0) throw new IndexOutOfBoundsException
      val numbers = crossVertically(i)
      assert(numbers.length == 3)
      numbers
    }

    private def crossVertically: Seq[Seq[Number]] =
      numbers.values.grouped(3).toSeq
  }

  case class Line(numbers: Numbers) extends Validatable

  object Line {
    def apply(numbers: Seq[Number]): Line = Line(Numbers(numbers))
  }

  def main(args: Array[String]): Unit = {
    val input =
      """[
     ["5","3",".",".","7",".",".",".","."],
     ["6",".",".","1","9","5",".",".","."],
     [".","9","8",".",".",".",".","6","."],
     ["8",".",".",".","6",".",".",".","3"],
     ["4",".",".","8",".","3",".",".","1"],
     ["7",".",".",".","2",".",".",".","6"],
     [".","6",".",".",".",".","2","8","."],
     [".",".",".","4","1","9",".",".","5"],
     [".",".",".",".","8",".",".","7","9"]
     ]"""

    //    println(strToCharArray("[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"] ").mkString(","))

    strToNextedCharArray(input)
      .foreach(strArray => println(strArray.mkString(",")))
  }


  // ["5","3",".",".","7",".",".",".","."] ->
  def strToCharArray(str: String): Array[Char] = {
    Array.from(str.
      replace(",", "").
      replace("\"", "").
      replace("[", "").
      replace("]", ""),
    )
  }


  def strToNextedCharArray(str: String): Array[Array[Char]] = {
    val contents = str
      .replace("[", "")
      .replace("],", "")
      .filter(_ != " ".head)
      .split("\n")

    contents.map(strToCharArray)
  }

}
