object MaxList extends App {
 /*
  <% is a view bound it basically says you can use T
  as long as it can be treated as an Ordered[T]

  This is different than saying it can be an Ordered[T]. 
  This is because it will except T if there is an implicit
  conversion to Ordered[T]

 */
  def maxListImpBound[T <% Ordered[T]](elements: List[T]): T =
    elements match{
      case Nil =>
        throw new IllegalArgumentException("empty");
      case x :: Nil => x
      case x ::rest => 
        val maxRest = maxListImpBound(rest)
          if (x > maxRest) x
          else maxRest
    }
}
