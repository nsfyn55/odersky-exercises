/*

abstract class AbstractCurrency {
  type Currency <: AbstractCurrency
  val amount: Long
  def designation: String
  override def toString = amount + " " designation
  def + (that: Currency): Currency = ...
  def * (x: Double): Currency = ...
}

This class definition has a problem. Abstract types cannot
be instantiated. The compiler will not allow us to implement
the +  method as an addition of the amounts of two 
currencies returned as a new Currency instance.

This could be fixed by adding a factory method in the Currency
class, - def make(amount: Long) - but this presents a few
problems. The biggest of which is if you have an instance of
Currency you are free to make other Currency objects of 
arbitrary amounts

The answer to this problem is create another class and move
the factory method there. Introduce CurrencyZone

*/
abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  val CurrencyUnit: Currency 
  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def + (that: Currency): Currency = 
      make(this.amount + that.amount)
    def * (x: Double): Currency = 
      make((this.amount * x).toLong)
    def - (that: Currency): Currency = 
      make(this.amount - that.amount)
    private def decimals(n: Long): Int = 
      if (n == 1) 0 else 1 + decimals(n / 10)
    override def toString = 
      ((amount.toDouble / CurrencyUnit.amount.toDouble)
       formatted ("%." + decimals(CurrencyUnit.amount) + "f")
       + " " + designation)
  }
}
