package org.stairwaybook.expr
import org.stairwaybook.layout.LayoutElement
import org.stairwaybook.layout.LayoutElement.elem

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operation: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, righ: Expr) extends Expr

class ExpressionFormatter{
  //create an array of operator groups
  //in increasing order of precedence

  private val opGroups =
    Array( 
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=",">",">="),
      Set("+", "-"),
      Set("*", "%"))
  
  //Create a mapping from operators to precedence
  private val precedence = {
    val assocs = 
      for {
        i <- 0 until opGroups.length
        op <- opGroups(i)
      }yield op -> i
    assocs.toMap
  }
  
  private val unaryPrecedence = opGroups.length
  private val fractionPrecidence = -1

  private def format(e: Expr, enclPrec: Int): LayoutElement =

  e match {
    case Var(name) =>
      elem(name)
    case Number(num) =>
      def stripDot(s: String) =
        if (s endsWith ".0") s.substring(0,s.length-2)
        else s
      elem(stripDot(num.toString))
    case UnOp(op, arg) => 
      elem(op) beside format(arg, unaryPrecedence)
    case BinOp("/", left, right) =>
      val top = format(left, fractionPrecidence)
      val bot = format(right, fractionPrecidence)
      val line = elem('-', top.width max bot.width, 1)
      val frac = top above line above bot
      if (enclPrec != fractionPrecidence) frac
      else elem(" ") beside frac beside elem(" ")
    case BinOp(op, left, right) =>
      val opPrec = precedence(op)
      val l = format(left, opPrec)
      val r = format(right, opPrec + 1)
      val oper = l beside elem(" " + op + " ") beside r
      if (enclPrec <= opPrec) oper
      else elem("(") beside oper beside elem(")")
    }
  def format(e: Expr): LayoutElement = format(e, 0) 
}
