package uk.gov.hmrc.shoppingcart

import org.specs2.mutable.Specification

/**
 * To test Store Offers functionality
 * @author rambabu.posa
 */
class OffersITest extends Specification{

  "On Buy One Get One offer: When one item cost is 0.60, then 2 items cost should be 0.60" in {
    Offers.buyOneGetOneOffer(2 , 0.60) must be equalTo 0.60
  }

  "On Buy One Get One offer: When one item cost is 0.60, then 3 items cost should be 1.20" in {
    Offers.buyOneGetOneOffer(3 , 0.60) must be equalTo 1.20
  }

  "On Three For Two offer: When one item cost is 0.25, then 3 items cost should be 0.50" in {
    Offers.threeForTwoOffer(3 , 0.25) must be equalTo 0.50
  }

  "On Three For Two offer: When one item cost is 0.25, then 6 items cost should be 1.00" in {
    Offers.threeForTwoOffer(6 , 0.60) must be equalTo 2.40
  }

  "Apples have Buy One Get One offer" in {
    Offers.offer("apple")(2) must be equalTo ShoppingCart.getPrice("apple")
  }

  "Oranges have Three For Two offer" in {
    Offers.offer("orange")(3) must be equalTo (2 * ShoppingCart.getPrice("orange"))
  }

}
