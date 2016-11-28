/*
 * Copyright (c) 2016, Visualobjects and/or its affiliates. All rights reserved.
 * Visualobjects PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
class Menu(val menuList:List[Food]) {

}

// Potentially this list can be much bigger than this but this will do for the sake of simplicity
object Menu extends Menu(
    ColdLargeCola ::
    ColdRegularCola ::
    RegularOrange ::
    Coffee ::
    HotCheeseSandwich ::
    ColdCheeseSandwich ::
    HotSteakSandwich ::
    ColdSteakSandwich :: Nil) {
}
