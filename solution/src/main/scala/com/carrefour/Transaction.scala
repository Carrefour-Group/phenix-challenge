package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Transaction(txId: Long, date: String, shopId: String, produit: Long, qte : Long, price: Double)

object Transaction {

  def addPriceToTransaction(priceMap: Map[(Long, String, String), Double]): Transaction => Option[Transaction] =
    t => {
      try {
        Some(Transaction(t.txId, t.date, t.shopId, t.produit, t.qte, priceMap(t.produit, t.date, t.shopId)))
      } catch {
        case e: Exception =>
          Logger.getAnonymousLogger.warning(s"Caught the following exception while adding price to transaction $t: $e.")
          None
      }
    }

  def getTransactions(date: String): List[Transaction] =
    Source.fromResource(s"transactions_$date.data").getLines.flatMap(parseTransaction(date)).toList

  def parseTransaction(date: String)(s: String): Option[Transaction] = {
    val sList = s.split('|').map(_.trim)
    try {
      Some(Transaction(sList(0).toLong, date, sList(2), sList(3).toLong, sList(4).toLong, -1L))
    } catch {
      case e: Exception =>
        Logger.getAnonymousLogger.warning(s"Caught the following exception while parsing the transaction line $s: $e.")
        None
    }

  }
}