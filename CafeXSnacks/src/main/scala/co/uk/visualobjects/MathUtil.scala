/*
 * Copyright (c) 2016, Visualobjects and/or its affiliates. All rights reserved.
 * Visualobjects PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package co.uk.visualobjects

/**
  * Created by Homayoun on 27/11/2016.
  */
object MathUtil {
  def roundAt(p: Int)(n: Double): Double = {
    val s = math pow (10, p)
    (math round n * s) / s
  }
}
