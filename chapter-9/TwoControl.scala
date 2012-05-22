import java.io.{PrintWriter,File}
object TwoControl {

  def main(args: Array[String]){
    
    val file = new File("date.txt")

    withPrintWriter(file){
      writer => writer.println(new java.util.Date)
    } 
  }
  
  def withPrintWriter(file: File)(op: PrintWriter => Unit){
    val writer = new PrintWriter(file)
    try{
      op(writer)
    } finally {
      writer.close()
    }
   }
}

/*
  This example demonstrates the withPrintWriter function with currying
  its op applied to the result of withPrintWriter(file)
*/
