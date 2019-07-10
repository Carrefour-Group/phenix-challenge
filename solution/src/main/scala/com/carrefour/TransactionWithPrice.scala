package com.carrefour

import java.util.logging.Logger

case class TransactionWithPrice(txId: Long, date: String, shopId: String, produit: Long, qte : Long, price: Double)

object TransactionWithPrice {

  def addPriceToTransaction(priceMap: Map[(Long, String, String), Double]): Transaction => Option[TransactionWithPrice] =
    t => {
      try {
        Some(TransactionWithPrice(t.txId, t.date, t.shopId, t.produit, t.qte, priceMap(t.produit, t.date, t.shopId)))
      } catch {
        case e: Exception =>
          Logger.getAnonymousLogger.warning(s"Caught the following exception while adding price to transaction $t: $e.")
          None
      }
    }

}