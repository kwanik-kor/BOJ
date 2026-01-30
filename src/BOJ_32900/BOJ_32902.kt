package BOJ_32900

fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val (a, b) = n + 1 to (k * n + 1)
    println("${minOf(a, b)} ${maxOf(a, b)}")
}