/*
This is illegal because enqueue attempts to
use Type Parameter T (A covariant Type) in a
contravariant position.

class Queue[+T] {
  def enqueue(x:T){
    print("Enqueu Something")
  }
}
*/

/*
This is legal because we have defined a lower 
bound for the enqueue method. Specifying that
the type range for the method is limited
to subtypes of T.

Queue[Object] can enqueue anything that
is a supertype of Object and will return 
a Queue[Object]

*/
class Queue[+T] {
  def enqueue[U >: T](x: U){
    print("Enqueu Something")
  }
}
