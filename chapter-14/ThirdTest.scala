import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import FinalElement.elem

/*
Fun Suite allows you to define tests as function values rather than methods
*/

class ElementSpec extends FlatSpec with ShouldMatchers{
  "A Uniform Element" should
    "have a width equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.width should be (2)
    }
  
   it should
    "have a height equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.height should be (3)
    }

   it should
    "have a height equal to 4" in {
      val ele = elem('x', 2, 3)
      ele.height should be (4)
    }
}
