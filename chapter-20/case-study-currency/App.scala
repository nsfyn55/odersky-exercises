object App {
  def main(args: Array[String] ){
    val d = US.make(100)
    val d2 = US.make(200)
    
    val d3 = d + d2

    println(d3)
  }
}

