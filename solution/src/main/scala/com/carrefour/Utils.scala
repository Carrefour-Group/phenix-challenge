package com.carrefour

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Utils {

  def last7Days(dateString: String): List[String] = {
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val dayJ = LocalDate.parse(dateString, formatter)
    val dates: List[String] = List[String](dateString)
    (1 to 6).foldLeft(dates) {
      (acc, i) => formatter.format(dayJ.minusDays(i)) :: acc
    }
  }

}