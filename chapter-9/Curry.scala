object Curry {
  def main (arg: Array[String]){
    println("Hello World!")
    println(plainOldSum(1,2))
    println(curriedSum(1)(2))
  }
  def plainOldSum(x: Int, y: Int) = x+y

  def curriedSum(x: Int)(y: Int) = x+y

}
