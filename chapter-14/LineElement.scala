class LineElement(s: String) extends Element{
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}
/*
    This class invokes a super class constructor right in the extends clause
*/
