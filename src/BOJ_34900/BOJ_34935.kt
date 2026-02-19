package BOJ_34900

import java.math.BigDecimal

fun main() {
    val n = readln().toInt()
    readln()
        .split(" ")
        .map(::BigDecimal)
        .zipWithNext()
        .all { (a, b) -> a < b }
        .let { isAscending ->
            println(if (isAscending) 1 else 0)
        }
}