import scala.math

object BinnarySearch {
   val search = 9
   var comparisons = 0

   def main(args: Array[String]) {
   	doSearch(List(1,2,3,4,5,6,7,8,9))
      System.out.println(this.comparisons + " comparisons made to find the value")
   }

   def doSearch(list: List[Int]) {
   	this.comparisons = this.comparisons + 1
      var middleIndex = getMiddleIndex(list)
      if (this.search > list(0)) return doSearch(list.takeRight(middleIndex))
      if (this.search < list(0)) return doSearch(list.take(middleIndex))
      if (this.search == list(0)) System.out.println("achou bitch")
   }

   def getMiddleIndex(list: List[Int]) : Int = {
      return math.round(list.size - list.size/2).toInt
   }
}