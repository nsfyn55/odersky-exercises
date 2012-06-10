abstract class Element {
  def contents: Array[String]

  def above(that: Element): Element = 
    new ArrayElement(this.contents ++ that.contents)

  def beside(that: Element): Element = {
    new ArrayElement(
      for (
          (line1, line2) <- this.contents zip that.contents
        )yield line1 + line2
    )
  }
    
  def height: Int = contents.length
  def width: Int = if(height == 0) 0 else contents(0).length

  override def toString = contents mkString "\n"
}
/*
Old Implementation

  def beside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)
    for(i <- 0 until this.contents.length)
      contents(i) = this.contents(i) + that.contents(i)
    new ArrayElement(contents)
  }
  
  this is in imperative style. It is known because there is a loop with index i addressing
  array positions. Refer to current impl for functional style

  The zip method takes two arrays and creates a new array of Tuple2'
*/
/*
Notes:

  There is no abstract modifier on contents. In Scala methods are inherintely abstract if they
  lack implementations. Not only that, but you couln't provide one even if you wanted to. Abstract
  modifiers aren't allowed on methods in scala.

  Definitions vs. Declarations:
    contents in declared but not defined.


  Parameterless Methods:
    width and height lack parameters. This convention should be applied whenever there are no parameters
    and mutable state is accessed only through reads.


  Uniform Access Principle:
    Client code should not be affected by the decision to implement something as a field or a method

  Problem
    java does not implement Uniform Access Principle. Scala is very liberal with omitting parens to 
    bridge this gap

    convention: Supply parens if the method represents more than a property of the reciever - give
    then client a visual indicator that the method is doing something interesting
 	      "hello".length -  Ok to leave off paren
        println() -       Ecapsulates interesting behavior best to include it


*/
