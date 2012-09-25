object Queue {
  def apply[T](xs: T*): Queue[T] = 
    new Queue[T](xs toList, Nil)
}

/*
This implementation of the a functional 
queue demonstrates two principals. 

First it demonstrates a covariant type parameter
in an implementation with reassignable fields. The
reason this is allowed is because the fields in
question are private to this instance. This allows
the class to retain its status as a purely functional
queue and it will allow the variance checker to ok
the covariant Type .

*/
class Queue[+T] private (
  private[this] var leading: List[T],
  private[this] var trailing: List[T]
) {

  private def mirror() =
    if(leading.isEmpty) {
      while(!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
    
 def head: T = {
   mirror()
   leading.head
 }

 def tail: Queue[T] = {
   mirror()
   new Queue(leading.tail, trailing)
 }

 def enqueue[U >:T](x: U) =
   new Queue[U](leading, x :: trailing)
}
