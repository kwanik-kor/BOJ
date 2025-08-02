package BOJ_01300

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

fun main() {
    val format = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH)
    val current = LocalDateTime.parse(readLine()!!, format)

    val year = current.year
    val start = LocalDateTime.of(year, 1, 1, 0, 0)
    val end = LocalDateTime.of(year, 12, 31, 23, 59)

    val totalMinutes = ChronoUnit.MINUTES.between(start, end) + 1;
    val passedMinutes = ChronoUnit.MINUTES.between(start, current);

    val percentage =  passedMinutes.toDouble() / totalMinutes * 100;

    println("%.9f".format(percentage))
}