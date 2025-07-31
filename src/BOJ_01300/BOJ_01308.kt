package BOJ_01300

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
    val format = DateTimeFormatter.ofPattern("y M d")
    val from = LocalDate.parse(readLine()!!, format)
    val to = LocalDate.parse(readLine()!!, format)

    if (!to.isBefore(from.plusYears(1000))) {
        println("gg")
    } else {
        println("D-${ChronoUnit.DAYS.between(from, to)}")
    }
}