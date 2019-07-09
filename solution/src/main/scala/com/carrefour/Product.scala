package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Product(produit: Long, prix: Double)

object Product {

  def getProducts(magasin: String, date: String): List[Product] =
    Source.fromResource(s"reference_prod-$magasin" + s"_$date.data").getLines.flatMap(parseProduct).toList

  def parseProduct(s: String): Option[Product] = {
    val sList = s.split('|').map(_.trim)
    try {
      Some(Product(sList(0).toLong, sList(1).toDouble))
    } catch {
      case e: Exception =>
        Logger.getAnonymousLogger.warning(s"Caught the following exception while parsing the product line $s: $e.")
        None
    }
  }
}