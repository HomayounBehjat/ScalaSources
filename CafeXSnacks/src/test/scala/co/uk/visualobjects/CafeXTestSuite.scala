/*
 * Copyright (c) 2016, Visualobjects and/or its affiliates. All rights reserved.
 * Visualobjects PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

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
    // And I will have a Coffee
    val coffee:Food = Menu.menuList.find(_.name == FoodNames.Coffee).get

    // This is my lunch - Sometimes! - This is my order
    val hotCheeseSandwichOrderItem: OrderItem = new OrderItem(hotCheeseSandwich, 1)
    val coldRegularColaOrderItem: OrderItem = new OrderItem(coldRegularCola, 1)
    val coffeeOrderItem: OrderItem = new OrderItem(coffee, 1)
    val orderItems = ListBuffer.empty[OrderItem] += hotCheeseSandwichOrderItem += coldRegularColaOrderItem += coffeeOrderItem
    val myOrder:Order = new Order(orderItems ,new Date(),OrderStatus.Processing)
    val orderTotal:Double = new BillPayment(myOrder).calculateOrderTotal()

    // This amount now includes a service charge of 20%
    assert(orderTotal == 4.20)
  }

  test("Check that drink only Orders do not attract a service charge") {
    // Lookup the cold regular cola from the menu
    val coldRegularCola:Food = Menu.menuList.find(_.name == FoodNames.ColdRegularCola).get
    // Lookup the coffee from the menu
    val coffee:Food = Menu.menuList.find(_.name == FoodNames.Coffee).get

    // I'll order a regular cola for myself and one for my colleague - His birthday today.
    val coldRegularColaOrderItem: OrderItem = new OrderItem(coldRegularCola, 2)
    // And I'll order a coffee for my colleague and a Coffee for myself
    val coffeeOrderItem: OrderItem = new OrderItem(coffee, 2)

    val orderItems = ListBuffer.empty[OrderItem] += coldRegularColaOrderItem += coffeeOrderItem
    val myOrder:Order = new Order(orderItems ,new Date(),OrderStatus.Processing)

    // This amount should not includes any service charges
    assert(new BillPayment(myOrder).calculateOrderTotal() == 3.00)
  }

  test("Check that large Orders do not attract more than £20 service charge") {
    // Lookup the cold regular cola from the menu
    val coldRegularCola:Food = Menu.menuList.find(_.name == FoodNames.ColdRegularCola).get
    // Lookup the coffee from the menu
    val coffee:Food = Menu.menuList.find(_.name == FoodNames.Coffee).get
    // Lookup the Steak Sandwich from the menu
    val hotSteakSandwich:Food =  Menu.menuList.find(_.name == FoodNames.HotSteakSandwich).get

    // I'll order 20 hot Steak Sandwiches - Its an Office Christmas Party
    val hotSteakSandwichOrderItem: OrderItem = new OrderItem(hotSteakSandwich, 20)
    // I'll order 20 regular colas
    val coldRegularColaOrderItem: OrderItem = new OrderItem(coldRegularCola, 20)
    // And I'll order 20 coffees
    val coffeeOrderItem: OrderItem = new OrderItem(coffee, 20)

    val orderItems = ListBuffer.empty[OrderItem] += hotSteakSandwichOrderItem += coldRegularColaOrderItem += coffeeOrderItem
    val myOrder:Order = new Order(orderItems ,new Date(),OrderStatus.Processing)
    val billPayment: BillPayment = new BillPayment(myOrder)

    // This amount now includes a service charge of 20%
    assert(billPayment.calculateOrderTotal() == 140.00)
    assert(billPayment.serviceChargeAmount() == 20.0)
  }
}