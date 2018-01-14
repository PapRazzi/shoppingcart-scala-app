package uk.gov.hmrc.shoppingcart

import scala.math.BigDecimal.RoundingMode

/**
 * Represent Shopping Cart
 * @author rambabu.posa
 */
object ShoppingCart {

  // Each Item price.
  private val itemsPriceList: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  /**
   * To perform checkout operation with list of selected items
   * @param items A list of items
   * @return      Total cost
   */
  def checkout(items: Array[String]): Double = {
    val total = items.flatMap(price).sum
    BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN).toDouble
  }

  def getPrice(item: String): Double = {
    itemsPriceList.getOrElse(item toLowerCase, 0)
  }

  def price(item: String): Option[Double] = itemsPriceList.get(item toLowerCase)

}
