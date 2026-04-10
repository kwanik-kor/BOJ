package BOJ_31200

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toLong() }
    val diff = k - m
    println((n + diff - 1) / diff)
}
