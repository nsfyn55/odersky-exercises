/*
The result of place queens is a List of List of (Int, Int)

result of placeQueens(3)
            --> placeQueens(2)
                --> placeQueens(1)
                    --> placeQueens(0) --> List(List())

filter drops from the iteration all elements for which 
the expression returns false
*/
object Run extends App{

  def queens(n: Int): List[List[(Int,Int)]] = {
    def placeQueens(k: Int): List[List[(Int,Int)]] =
      if (k == 0)
        List(List())
      else{
        val res =  for {
          queens <- placeQueens(k-1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens) // dropped from iteration if they aren''
        }yield queen :: queens
        println(res) 
        return res
      }
    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) = 
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2:(Int, Int)) = 
    q1._1 == q2._1 ||
    q1._2 == q2._2 ||
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

}
