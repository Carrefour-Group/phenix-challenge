package com.carrefour

import Transaction.getTransactions
import Product.getProducts
import Magasin.MagasinIds

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    val products: List[Product] = getProducts(MagasinIds.head, "20170514")
    transactions.take(10).foreach(t => println(t))
    products.take(10).foreach(t => println(t))
  }





}