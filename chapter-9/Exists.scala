object Exists {
  def main(args: Array[String]){
    println("Hello World!")
    val l = List(1,2,3)
    println(containsNeg(l))

    val l2 = List(1,2,-3)
    println(containsNeg(l2))

    val l3 = List(1,2,-3)
    println(altContainsNeg(l3))
  }
  
  def containsNeg(nums: List[Int]): Boolean ={
    var exists = false
    for (num <-nums)
      if (num < 0)
        exists = true

    exists
  }

  def altContainsNeg(nums: List[Int]) = nums.exists(_<0)
}
