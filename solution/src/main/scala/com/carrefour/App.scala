package com.carrefour

import Transaction.getTransactions

object App {

  def main(args: Array[String]): Unit = {
    val dayJ: String = "20170514"
    val last7Days: List[String] = Utils.last7Days(dayJ)
    last7Days.foreach(println)
    val transactions: List[Transaction] = getTransactions(List(dayJ))
    println(transactions.size)
    transactions.take(10).foreach(println)

  }





}