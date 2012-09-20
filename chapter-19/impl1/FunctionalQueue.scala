object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList,Nil)
}
class Queue[T](
   private val leading: List[T],
    private val trailing: List[T]
  ) {
  
    /*
      if leading.isEmpty return a new Queue
      where trailing is reversed and leading
      is Nil
  
      Otherwise return a reference to the current 
      queue
  
      this means that trailing drains into leading
      if leading is empty
    */
    private def mirror =
      if(leading.isEmpty)
        new Queue(trailing.reverse, Nil)
      else
        this
  
    /*
      head is either the end of
      the trailing queue if leading is empty
      or the head of leading
    */
    def head = mirror.leading.head
    
    /*
      attempt to drain trailing into leading
  
      it then tails the tail of the leading portion
      and puts it into leading and leaves trailing 
      as it is.
  
      We have to mirror in case leading is empty
      
    */
    def tail = {
      val q = mirror
      new Queue(q.leading.tail, q.trailing)
    } 
       
    /*  
      in an enqueue operation you simply
      prepend the enqueue value to to
      trailing portion of the queue.
    */
    def enqueue(x: T) =
      new Queue(leading, x :: trailing)
  }
