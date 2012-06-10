import FinalElement.elem

object Spiral { 
  val space = elem(" ")
  val corner = elem("+")

  /*
    spiral is a recursive function that accepts two parameters
      a number of edges and a direction to spiral


    defines a few internal members
    sp - a new spiral element consisting of edges minus one
         and direction of the current direction + 3 % 4

         direction chart
         0 -> 3 % 4 -> 3
         1 -> 4 % 4 -> 0
         2 -> 5 % 4 -> 1
         3 -> 6 % 4 -> 2

    next define three things
    sp - a spiral with one less edge and the next direction

    verticalBar - an elem of wideth 1 and sp's height that
    consists of a pip

    horizontalBar - an elem of '-'s that is the spirals
    wideth and a height of 1

    a corner is just a "+" sign

    so we get edges down to 

    
    Example with 4 edges    

    spiral(4,0)--> ('+' beside '-') above (sp beside space)
                    +-                     | |              +---- 
                                           | |  +           |
                                           | +--+           |  +
                                                            +--+
      spiral(3,3) --> ("| above '+') beside (' ' above sp)
                        |                                   |     
                        +                         +         |  +
                                                --+         +--+

        spiral(2,2) --> (" " beside +) above (-- beside +)    +
                                                            --+
            spiral(1,1) --> +



  */
  def spiral(nEdges: Int, direction: Int): FinalElement = {

    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above ( sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above ( horizontalBar beside corner)
      else
        (verticalBar above corner) beside(space above sp)

    }
  }
  /*
   def main takes a number of edges and creates a spiral for that many edges
  */
  def main(args: Array[String]){
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}
