/*
 * Copyright (c) 2016, Visualobjects and/or its affiliates. All rights reserved.
 * Visualobjects PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
class BillPayment(val order:Order) extends Bill {

  val serviceChargeRules:List[Rule] = List(allDrinksRule,hotFoodRule,coldFoodRule)

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

  private def applyServiceChargeRules(rules:List[Rule]): Double = rules match {
      case aRule :: rest =>
        val res = aRule.processServiceChargeRule(order)
        if (res == -1)
          applyServiceChargeRules(rest)
        else
          res
      case Nil => throw new RuntimeException("Impossible Situation - No Service Charge Rule found To Apply")

  }

  def serviceChargeAmount(): Double = {
    applyServiceChargeRules(serviceChargeRules)
  }

  override def calculateOrderTotal(): Double = {
    MathUtil.roundAt(2)(order.total() + serviceChargeAmount())
  }
}