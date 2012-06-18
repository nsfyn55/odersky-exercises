package org.stairwaybook.layout
import org.stairwaybook.layout.LayoutElement.elem

/*
  Class Element Wraps an array of strings
  what you have is an array of strings
  of arbitrary length there are couple of operations of interest

  above - puts takes a element and another element widens both so they
  are the same width and concatenates the arrays so you end up with
  this above that

  array 1 -  0  aa     array 2 - 0 bb
             1  aa               1 bb 

  result:  0 aa
           1 aa
           2 bb 
           3 bb 


  beside - takes two elements, first ensures they are the same height, then
  processes each array appending the contents of that to this

  array 1 -  0  aa     array 2 - 0 bb
             1  aa               1 bb 

  result:  0 aabb
           1 aabb


*/
abstract class LayoutElement{

  def contents: Array[String]

  def width: Int = contents(0).length
  def height: Int = contents.length

  /*
    takes an element
    widens this element to the width of that
    widends that element to the width of this
    appends the contents of this and that

    this - **
    that - ***

    result  - ** \n
              ***\n
  */
  def above(that: LayoutElement): LayoutElement = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }
  
  /*
    takes an element
    extends the height of both this and that
    such that concatenates arrays as two vertical
    columns

    *
    
  */
  def beside(that: LayoutElement): LayoutElement = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
          (line1, line2) <- this1.contents zip that1.contents
        )yield line1 + line2
    )
  }
  /*
    widens contents by a factor of w -
    first it assigns an elem of left that is a uniform elem
    of ' ' chars, with a width of (w - width)/2 and a height of the current 
    height

    it then assigns an elem of right which is a UniformElement of
    ' ' chars, with a width of w - width - left's width, and a hieght of hieght

    so a w of 2 on a width of 1 will create an array of padding left that is  0 ' 's wide
    and a padding right that is 2 - 1 -0 = 1 ' '  wide

    it then calls the left.beside(this.beside.(right))

    start : 0 - a
            1 - b
            2 - c
    widen(2)

    result: 0 - a<sp>
            1 - b<sp>
            2 - c<sp>
            
    
  */
  def widen(w: Int): LayoutElement = 
    if (w <= width) this
    else {
        val left = elem(' ', (w - width) / 2, height)
        var right = elem(' ', w - width - left.width, height)
        left beside this beside right
    }
 /*
  heighten is the same principle as widen except that it creates uniform top and
  bottom given the hieght param and calls
  top.above(this.above(bot))
 */
  def heighten(h: Int): LayoutElement = 
    if ( h <= height) this
    else{
      val top = elem (' ', width, (h - height) / 2)
      var bot = elem (' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}

object LayoutElement {
  /*
    array elem is a regular elem that
    is formed from an array of strings
  */
  private class ArrayElement(
    val contents: Array[String]
  )extends LayoutElement

 /*
  Line Element is just a string 
 */
  private class LineElement(s: String) extends LayoutElement {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }

  /* 
    Uniform Element is Element of a given char 
    expanded over a width and height
  */
  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  )extends LayoutElement {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): LayoutElement = 
    new ArrayElement(contents)
  
  def elem(chr: Char, width: Int, height: Int): LayoutElement = 
    new UniformElement(chr, width, height)

  def elem(line: String): LayoutElement = 
    new LineElement(line)
}
