package BOJ_28500

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(if (a == b) a * 2 else minOf(a, b) * 2 + 1)
}