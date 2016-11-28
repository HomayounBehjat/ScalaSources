/*
 * Copyright (c) 2016, Visualobjects and/or its affiliates. All rights reserved.
 * Visualobjects PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
trait Bill {
  val order:Order
  var paymentType: PaymentType.Value
  var isBillPaid:Boolean
  def calculateOrderTotal():Double
  def serviceChargeAmount(): Double
}

object PaymentType extends Enumeration {

  val CashPayment = Value("Cash Payment")
  val CardPayment = Value("Card Payment")
  val ChequePayment = Value("Cheque Payment")
}