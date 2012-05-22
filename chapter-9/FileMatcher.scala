object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def main(args: Array[String]){
    var files = filesEnding("scala")
    files.foreach(f => println(f))

    println("")
    println("")

    files = filesContaining("File")
    files.foreach(f => println(f))

    println("")
    println("Always Empty")

    files = alwaysEmpty()
    files.foreach(f => println(f))
  }
  
  def test(value: String) = 
    false 

  def alwaysEmpty() =
    filesMatching(test)

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) = 
    filesMatching(_.contains(query))

  def filesMatching(matcher: (String) => Boolean) = {
      for(file <- filesHere; if matcher(file.getName))
        yield file
    }
}
