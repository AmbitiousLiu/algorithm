package sort.quickSort

/**
 * @author jleo
 * @date 2020/5/18
 */
object QuickSort_scala {
  def main(args: Array[String]): Unit = {
    println(quickSort(Array(1,5,6,8,3,6,4,2,0).toList))
  }

  def quickSort(nums: List[Int]): List[Int] = {
    nums match {
      case Nil => Nil
      case List() => List()
      case _ => {
        val (smaller,larger)= nums.tail.partition(num => num < nums.head)
        quickSort(smaller) ::: (nums.head :: quickSort(larger))
      }
    }
  }
}
