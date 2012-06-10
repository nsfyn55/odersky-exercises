import org.scalatest.FunSuite
import FinalElement.elem

/*
Fun Suite allows you to define tests as function values rather than methods
*/

class OtherElementSuite extends FunSuite {
  test("Elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
  
  test("Elem result should have passed width With Expect") {
    val ele = elem('x', 2, 3)
    expect(2){
      ele.width
    }
  }
  
  test("Intercept illegal arg") {
     intercept[IllegalArgumentException] {
      elem('x', -2, 3)
     }
  }
}
