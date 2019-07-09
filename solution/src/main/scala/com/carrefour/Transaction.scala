package com.carrefour

import java.util.logging.Logger

import scala.io.Source

case class Transaction(txId: Long, datetime: String, magasin: String, produit: Long, qte : Long)

object Transaction {

  def getTransactions(date: String): List[Transaction] =
    Source.fromResource(s"transactions_$date.data").getLines.flatMap(parseTransaction).toList

  def parseTransaction(s: String): Option[Transaction] = {
    val sList = s.split('|').map(_.trim)
    try {
      Some(Transaction(sList(0).toLong, sList(1), sList(2), sList(3).toLong, sList(4).toLong))
    } catch {
      case e: Exception =>
        Logger.getAnonymousLogger.warning(s"Caught the following exception while parsing the line $s: $e.")
        None
    }

  }
}