object App {
  def main(args: Array[String]){
    println("Hello")
    
    val l  = List(2,1,4,3)

      val intSort = msort((x:Int, y:Int) => x < y)_
      val s = intSort(l)
      
      s.foreach(println)
  }


  /*

  split the lists down to a length of 1
  msort((2,1,4,3)
    msort --> List(2,1) 
      msort(2)
      msort(1)
    msort --> List(4,3)
      msort(4)
      msort(3)
 
  the conquer phase consists of taking two lists, making a comparison of the heads,
  if the x head is less than the y prepend x to merge(xs1, ys) otherwise prepend y
  to a merge(xs, ys1) until one list or the other is empty

  (1,2) (3,4)
  

  1<3 so 1 :: merge((2),(3,4))
  2<3 so 2 :: merge(Nil,(3,4)) 
  xs is nil so return ys

  1 :: 2 :: 3 :: 4

  merge(msort(2,1), msort(4,3))
        msort(4,3) --> merge(msort(4), msort(3))
                   <-- 3 :: 4
        msort(2,1) 
                  --> merge(msort(2), msort(1))
                  <--  1 :: 2
        merge((1,2), (3,4))
              1 :: merge((2),(3,4))
                 2 :: merge(Nil,(3,4))
                    2 :: 3 :: 4

  */

  def msort[T](less: (T,T) => Boolean)
      (xs: List[T]): List[T] ={

    def merge(xs: List[T], ys: List[T]):List[T] =
      (xs, ys) match {
        case(Nil, _) => ys
        case(_, Nil) => xs
        
        case(x :: xs1, y :: ys1) =>
          if(less(x,y)) x :: merge(xs1,ys)
          else y :: merge(xs, ys1)
      }
    
    val n = xs.length / 2
    if(n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}
