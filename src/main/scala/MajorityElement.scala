object MajorityElement {
  object Solution {
    def majorityElement(nums: Array[Int]): Int = {
      nums.groupBy(identity).maxBy({ case (_, array) => array.length })._1
    }
  }
}
