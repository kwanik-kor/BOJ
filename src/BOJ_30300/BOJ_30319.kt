package BOJ_30300

import java.time.LocalDate

fun main() {
    val input = readln()
    val contestDate = LocalDate.parse(input)

    val deadline = LocalDate.of(2023, 10, 21).minusDays(35)

    println(if (contestDate <= deadline) "GOOD" else "TOO LATE")
}
