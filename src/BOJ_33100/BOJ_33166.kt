package BOJ_33100

fun main() {
    val (p, q) = readln().split(" ").map { it.toInt() }
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(minOf(p, q) * a + maxOf(0, q - p) * b)
}