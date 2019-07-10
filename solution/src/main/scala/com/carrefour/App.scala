package com.carrefour

import Transaction.getTransactions
import Product.{getAllProductsOfDay, productsToMap}
import TransactionWithPrice.addPriceToTransaction

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    val products: List[Product] = getAllProductsOfDay("20170514")
    val productsLookupMap: Map[(Long, String, String), Double] = productsToMap(products)
    val transactionsWithPrice: List[TransactionWithPrice] = transactions.flatMap(t => addPriceToTransaction(productsLookupMap)(t))
    transactions.take(10).foreach(t => println(t))
    transactionsWithPrice.take(10).foreach(t => println(t))
    println(transactions.size)
    println(transactionsWithPrice.size)
    transactions.filter(t => t.produit == 0).foreach(t => println(t))
  }





}