package com.carrefour

import Transaction.getTransactions
import Product.getAllProductsOfDay

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    val products: List[Product] = getAllProductsOfDay("20170514")
    transactions.take(10).foreach(t => println(t))
    products.take(10).foreach(t => println(t))
  }





}