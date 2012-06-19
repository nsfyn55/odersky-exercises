object App {
  def main(args: Array[String]){
    println("Hello")

    println(isort(List(2,4,1,3)))
    println(isort2(List(2,4,1,3)))
    println(isort3(List(2,4,1,3)))
  }

  /*
    if xs is empty return Nil
    else insert head and isort tail
    insert(2, isort(4,3,1) --> 1::3::4::Nil) --> 1 :: Insert(2,3::4::Nil) --> 2 :: 3 :: 4 // 1 :: 2 :: 3 :: 4
          insert(4, isort(1,3)) --> 1 :: Insert(4 , 3 :: Nil) --> 3 :: Insert(4, Nil) --> 4 :: Nil // 1 :: 3 :: 4 :: Nil
                insert(1, isort(3))  --> 1 :: 3 :: Nil
                      insert(3, isort(Nil)) -- > 3 :: Nil
  */

  def isort(xs: List[Int]): List[Int] = 
    if(xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  def isort2(xs: List[Int]): List[Int] = xs match { 
    case Nil => Nil
    case _ => insert2(xs.head, isort2(xs.tail))
   }

  def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => x :: xs
    case _ if x <= xs.head => x :: xs
    case _ => xs.head :: insert2(x, xs.tail)
  }

  def isort3(xs: List[Int]): List[Int] = xs match{ 
    case Nil => Nil
    case x :: xs => insert3(x, isort3(xs))
  }
  
  /*
    if x <= the current head do nothing
    otherwise shift the head of the rest to front
    and insert x. x will eventually find its
    position
  */
  def insert3(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x) 
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert3(x, ys)
  }

  
}
