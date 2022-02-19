package PizzaPOS

case class Pizza(crustSize: CrustSize, crustType: CrustType, toppings: Seq[Topping])

case class Order(Pizzas: Seq[Pizza], customer: Customer)

case class Customer(name: String, Phone: String, address: Address)

case class Address(street1: String, street2: Option[String], city: String, state: String, zipCode: String)

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

trait PizzaServiceInterface {
  def addTopping(p: Pizza, t: Topping): Pizza
  def removeTopping(p: Pizza, t: Topping): Pizza
  def removeAllToppings(p: Pizza): Pizza

  def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
  def updateCrustType(p: Pizza, ct: CrustType): Pizza

  type Money = BigDecimal

  def calculatePizzaPrice(
                           p: Pizza,
                           toppingsPrices: Map[Topping, Money],
                           crustSizePrices: Map[CrustSize, Money],
                           crustTypePrices: Map[CrustType, Money],

                         ): Money
}

trait PizzaService extends PizzaServiceInterface {
  override def addTopping(p: Pizza, t: Topping): Pizza = {
    p.copy(toppings = p.toppings :+ t)
  }

  override def removeTopping(p: Pizza, t: Topping): Pizza = {
    val toppings = p.toppings.filter(topping => topping != t)
    p.copy(toppings = toppings)
  }

  override def removeAllToppings(p: Pizza): Pizza = {
    p.copy(toppings = Seq[Topping]())
  }

  override def updateCrustSize(p: Pizza, cs: CrustSize): Pizza = {
    p.copy(crustSize = cs)
  }

  override def updateCrustType(p: Pizza, ct: CrustType): Pizza = {
    p.copy(crustType = ct)
  }

  override def calculatePizzaPrice(
                                    p: Pizza,
                                    toppingsPrices: Map[Topping, Money],
                                    crustSizePrices: Map[CrustSize, Money],
                                    crustTypePrices: Map[CrustType, Money]): Money = {
//    TODO implemente a real algorithm based on the Toppings sequece
    val base = BigDecimal(10)
    val numToppings = p.toppings.size
    val price = base + 1.00 * numToppings
    price
  }


}

object PizzaPOS extends App {

}
