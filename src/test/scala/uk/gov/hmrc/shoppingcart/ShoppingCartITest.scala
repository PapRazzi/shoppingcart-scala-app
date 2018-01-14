package uk.gov.hmrc.shoppingcart

import org.specs2.mutable.Specification

/**
 * To test Online Store Shopping Cart functionality
 * @author rambabu.posa
 */
class ShoppingCartITest extends Specification {

  "An Apple Price should be 0.60" in {
    ShoppingCart.getPrice("apple") must be equalTo 0.60
  }

  "An Orange price should be 0.25" in {
    ShoppingCart.getPrice("orange") must be equalTo 0.25
  }

  "Item's Price which doesn't exist in the store should be 0" in {
    ShoppingCart.getPrice("None") must be equalTo 0
  }

  "ShoppingCart.getPrice should work in case-insensitive manner" in {
    ShoppingCart.getPrice("APPLE") must be equalTo 0.60
    ShoppingCart.getPrice("ORANGE") must be equalTo 0.25
  }

  "In ShoppingCart, Checkout should show the price of 5 Apples: 3.0" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "apple", "apple")) must be equalTo 3.0
  }

  "In ShoppingCard, Checkout should show the price of 10 Apples: 6.0" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple","apple", "apple", "apple", "apple","apple", "apple", "apple")) must be equalTo 6.0
  }

  "In ShoppingCart, Checkout should show the price of 4 Oranges: 1.0" in {
    ShoppingCart.checkout(Array("orange", "orange", "orange", "orange")) must be equalTo 1.0
  }

  "In ShoppingCart, Checkout should show the price of one apple and one orange: 0.85" in {
    ShoppingCart.checkout(Array("apple", "orange")) must be equalTo 0.85
  }

  "In ShoppingCart, Checkout should show the price of 3 apples and 3 oranges: 2.55" in {
    ShoppingCart.checkout(Array("apple", "apple", "apple", "orange", "orange", "orange")) must be equalTo 2.55
  }

  "In ShoppingCart, irrespective of the items order, Checkout should show the price of 3 apples and 3 oranges: 2.55" in {
    ShoppingCart.checkout(Array("apple", "orange", "apple", "orange", "apple", "orange")) must be equalTo 2.55
  }

  "In ShoppingCart, irrespective of the items order, Checkout should show the price of Apple, Apple, Orange, Apple: 2.05" in {
    ShoppingCart.checkout(Array("Apple", "Apple", "Orange", "Apple")) must be equalTo 2.05
  }

}
