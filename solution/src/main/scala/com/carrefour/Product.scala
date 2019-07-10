package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Product(produit: Long, prix: Double, date: String, magasin: String)

object Product {

  def getAllProductsOfDay(date: String): List[Product] = Magasin.MagasinIds.flatMap(m => getProducts(m, date))

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