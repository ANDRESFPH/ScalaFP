package nestedCopy

case class Name(
                 firstName: String,
                 mi: String,
                 lastName: String
               )

case class CreditCard(
                       name: Name,
                       number: String,
                       month: Int,
                       year: Int,
                       cvv: String
                     )


case class BillingInfo(
                        creditCards: Seq[CreditCard]
                      )

case class User(
                 id: Int,
                 name: Name,
                 billingInfo: BillingInfo,
                 phone: String,
                 email: String
               )

object CopyObjects extends App {
  val andresName = Name("Andres", "Felipe", "Piedrahita")
  val andres = User(
    1,
    andresName,
    BillingInfo(
      Seq(
        CreditCard(
          andresName,
          "1234567",
          5,
          2024,
          "1820"
        )
      )
    ),
    "0157873790024",
    "andresfph1989@gmail.com"
  )

  val andres2 = andres.copy(phone = "015773790025")
  val andresNewLastName = andres2.name.copy(lastName = "German")
  val andres3 = andres2.copy(name = andresNewLastName)

  val newCreditCard = andres3.billingInfo.creditCards(0).copy(name = andresNewLastName)
  val newBillingInfo = andres.billingInfo.copy(creditCards = Seq(newCreditCard))
  val andres4 = andres3.copy(billingInfo = newBillingInfo)
  println(andres4)

}