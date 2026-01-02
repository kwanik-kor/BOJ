package BOJ_34000

fun main() = println(if ((0 until 4).sumOf { readln().toInt() } + 300 <= 1800) "Yes" else "No")