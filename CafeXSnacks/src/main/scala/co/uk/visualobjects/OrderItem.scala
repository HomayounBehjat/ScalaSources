package co.uk.visualobjects

/**
  * Created by Homayoun on 24/11/2016.
  */
class OrderItem(val foodItem: Food, val quantity: Int) {

  def total():Double = {
    quantity * foodItem.price
  }
}