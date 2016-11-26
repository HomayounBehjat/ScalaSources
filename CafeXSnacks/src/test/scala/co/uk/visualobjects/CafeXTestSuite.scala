package co.uk.visualobjects

import java.util.Date

import org.scalatest.{Tag, FunSuite}

import scala.collection.mutable.ListBuffer

/**
  * Created by Homayoun on 24/11/2016.
  */
class CafeXTestSuite extends FunSuite {

  test("Total of Orders Are Correct") {
    // I love Cheese Sandwich
    val hotCheeseSandwich:Food =  Menu.menuList.find(_.name == FoodNames.HotCheeseSandwich).get
    // And I will have a Regular Cold Cola
    val coldRegularCola:Food = Menu.menuList.find(_.name == FoodNames.ColdRegularCola).get

    // This is my lunch - Sometimes! - This is my order
    val hotCheeseSandwichOrderItem: OrderItem = new OrderItem(hotCheeseSandwich, 1)
    val regularColdColaOrderItem: OrderItem = new OrderItem(ColdRegularCola, 1)
    val CoffeeOrderItem: OrderItem = new OrderItem(Coffee, 1)
    //val orderItems = ListBuffer.concat(List(cheeseSandwichOrderItem,regularColdColaOrderItem))
    val orderItems = ListBuffer.empty[OrderItem] += hotCheeseSandwichOrderItem += regularColdColaOrderItem += CoffeeOrderItem
    val myOrder:Order = new Order(orderItems ,new Date(),OrderStatus.Processing)
    val orderTotal:Double = new BillPayment(myOrder).calculateOrderTotal()
    println(orderTotal)

    assert(orderTotal == 3.50)
  }
}


