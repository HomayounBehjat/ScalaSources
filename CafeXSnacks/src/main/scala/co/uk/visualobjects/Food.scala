package co.uk.visualobjects

/**
  * Created by Homayoun on 23/11/2016.
  */
abstract class Food(val name: FoodNames.Value, val price: Double, val size: Size.Value, val isCold: Boolean) {

  // There are a diversity of Food behaviour that applies to both Solid Foods
  // and Drinks which can be defined here. For the sake of simpilicity I have
  // not defined any.

  val isDrink:Boolean
}

class Drink(name: FoodNames.Value, price: Double, size: Size.Value, isCold:Boolean, val isDiet:Boolean)
    extends Food(name,price,size,isCold) {

  val isDrink: Boolean = true
}

class SolidFood(name: FoodNames.Value, price: Double, size: Size.Value, isCold:Boolean)
  extends Food(name,price,size,isCold) {
  val isDrink: Boolean = false

}

// These objects should ideally be constructed from a database when the application first
// starts up. I have put them here for the sake of simpilicity.

// Cold Regular Cola
object ColdRegularCola extends Drink(FoodNames(0),0.50,Size(1),true,false)

// Cold Large Cola
object ColdLargeCola extends Drink(FoodNames.ColdRegularCola,0.50,Size(2), true, false)

// Cold Regular Orange
object RegularOrange extends Drink(FoodNames.ColdRegularOrange,0.50,Size(1), true, false)

// A Hot Cup Of Coffee
object Coffee extends Drink(FoodNames.Coffee,1.0,Size(2),false, false)

// A Hot Cheese Sandwich
object HotCheeseSandwich extends SolidFood(FoodNames.HotCheeseSandwich, 2.0, Size(1), false)

// A Cold Cheese Sandwich
object ColdCheeseSandwich extends SolidFood(FoodNames.ColdCheeseSandwich,2.0,Size(1),true)

// A Hot Steak Sandwich
object HotSteakSandwich extends SolidFood(FoodNames.HotSteakSandwich, 4.50, Size(1), false)

// A Cold Steak Sandwich
object ColdSteakSandwich extends SolidFood(FoodNames.ColdSteakSandwich,2.0,Size(1),true)

// An Enumeration of the size of Foods
object Size extends Enumeration {
  val Small = Value("Small")
  val Regular = Value("Regular")
  val Large = Value("Large")
}

// An Enumeration of all food names
object FoodNames extends Enumeration() {
  val ColdRegularCola = Value("Cold Regula rCola")
  val ColdLargeCola = Value("Cold Large Cola")
  val ColdRegularOrange = Value("Cold Regular Orange")
  val Coffee = Value("Cofee")
  val HotCheeseSandwich = Value("Hot Cheese Sandwich")
  val ColdCheeseSandwich = Value("Cold Cheese Sandwich")
  val HotSteakSandwich = Value("Hot Steak Sandwich")
  val ColdSteakSandwich = Value("Cold Steak Sandwich")
}