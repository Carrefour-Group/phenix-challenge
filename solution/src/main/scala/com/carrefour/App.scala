package com.carrefour

import Transaction.getTransactions

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val transactions: List[Transaction] = getTransactions("20170514")
    //val top100VenteGlobal = transactions.groupBy()
    //Source.fromResource("transactions_20170514.data").getLines.foreach(t => println(t))
    transactions.take(10).foreach(t => println(t))
  }





}