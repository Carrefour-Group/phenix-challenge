package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Product(produit: Long, price: Double, date: String, shopId: String)

object Product {

  def productsToMap(products: List[Product]): Map[(Long, String, String), Double] =
    products map (p => (p.produit, p.date, p.shopId) -> p.price) toMap

  def getAllProductsOfDay(date: String): List[Product] = Shop.ShopIds.flatMap(m => getProducts(m, date))

  def getProducts(magasin: String, date: String): List[Product] =
    Source.fromResource(s"reference_prod-$magasin" + s"_$date.data").getLines.flatMap(parseProduct(date, magasin)).toList

  def parseProduct(date: String, magasin: String)(s: String): Option[Product] = {
    val sList = s.split('|').map(_.trim)
    try {
      Some(Product(sList(0).toLong, sList(1).toDouble, date, magasin))
    } catch {
      case e: Exception =>
        Logger.getAnonymousLogger.warning(s"Caught the following exception while parsing the product line $s: $e.")
        None
    }
  }
}