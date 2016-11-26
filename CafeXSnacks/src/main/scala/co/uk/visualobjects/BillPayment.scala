package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
class BillPayment(val order:Order) extends Bill {

  /**
    * Return the payment type as Cash for now as default.
    *
    * @return
    */
  var paymentType: PaymentType.Value = {
    PaymentType(0) //This is Cash
  }

  /**
    * We need some payment processing here. Its not just
    * a matter of saying the Payment is made or not.
    * But this will do for now.
    *
    * @return
    */
  var isBillPaid: Boolean = {
    false
  }

  override def calculateOrderTotal(): Double = {
    //order.orderItems.foldLeft(0.0)((total:Double, orderItem:OrderItem) => total + orderItem.total())
    order.orderItems.foldLeft(0.0)(_ + _.total())
  }
}