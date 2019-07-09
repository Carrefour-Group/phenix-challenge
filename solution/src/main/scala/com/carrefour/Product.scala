package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Product(produit: Long, prix: Double, date: String)

object Product {

  def getProducts(magasin: String, date: String): List[Product] =
    Source.fromResource(s"reference_prod-$magasin" + s"_$date.data").getLines.flatMap(parseProduct(date)).toList

  def parseProduct(date: String)(s: String): Option[Product] = {
    val sList = s.split('|').map(_.trim)
    try {
      Some(Product(sList(0).toLong, sList(1).toDouble, date))
    } catch {
      case e: Exception =>
        Logger.getAnonymousLogger.warning(s"Caught the following exception while parsing the product line $s: $e.")
        None
    }
  }
}