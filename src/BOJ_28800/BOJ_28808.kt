package BOJ_28800

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println((0 until n).count{ readln().contains("+") })
}
