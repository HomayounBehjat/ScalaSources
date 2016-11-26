package co.uk.visualobjects

import java.util.Date
import scala.collection.mutable.ListBuffer

/**
  * Created by Homayoun on 23/11/2016.
  */
class Order(val orderItems:ListBuffer[OrderItem], orderDate:Date, orderStatus: OrderStatus.Value) {
  /**
    * Tests whether this order includes any drink items
    * @return True if this Order contains any Drink order items.
    */
  def containsAtLeastOneDrink(): Boolean = {
    orderItems.exists(_.foodItem.isInstanceOf[Drink])
  }

  /**
    * Returns true if all the ordered food items are Drinks only.
    * @return
    */
  def containsAllDrinks(): Boolean = {
    orderItems.forall(_.foodItem.isInstanceOf[Drink])
  }

  /**
    * Add an OrderItem To this Order
    * @param orderItem The Order Item to be added
    */
  def addOrderItem(orderItem:OrderItem): Unit = {
    orderItems += orderItem
  }

  /**
    * Remove an Order Item from this order
    * @param orderItem The order Item to be removed
    */
  def removeOrderItem(orderItem:OrderItem): Unit = {
    orderItems -= orderItem
  }
}

// An Enumeration of the size of Foods
object OrderStatus extends Enumeration {
  val Served = Value("Served")
  val Waiting = Value("Waiting")
  val Processing = Value("Processing")
  val Cancelled = Value("Cancelled")
}