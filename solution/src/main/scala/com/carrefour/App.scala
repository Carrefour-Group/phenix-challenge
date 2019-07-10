package com.carrefour

import Transaction.getTransactions
import Product.{getAllProductsOfDay, productsToMap}

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    val products: List[Product] = getAllProductsOfDay("20170514")
    val productsLookupMap: Map[(Long, String, String), Double] = productsToMap(products)
    transactions.take(10).foreach(t => println(t))
    productsLookupMap.take(10).foreach(t => println(t))
  }





}