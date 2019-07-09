package com.carrefour

import scala.io.Source

object App {

  def main(args: Array[String]): Unit = {
    println("Hello")
    val t1 = Source.fromResource("transactions_20170514.data").getLines.toList.head
    println(t1)
  }

}