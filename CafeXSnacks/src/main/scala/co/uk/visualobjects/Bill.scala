package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
trait Bill {
  val order:Order
  var paymentType: PaymentType.Value
  var isBillPaid:Boolean
  def calculateOrderTotal():Double
}

object PaymentType extends Enumeration {

  val CashPayment = Value("Cash Payment")
  val CardPayment = Value("Card Payment")
  val ChequePayment = Value("Cheque Payment")
}