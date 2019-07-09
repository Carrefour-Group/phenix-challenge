package com.carrefour

import Transaction.getTransactions
import Product.getProducts

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    val products: List[Product] = getProducts("2a4b6b81-5aa2-4ad8-8ba9-ae1a006e7d71", "20170514")
    transactions.take(10).foreach(t => println(t))
    products.take(10).foreach(t => println(t))
  }





}