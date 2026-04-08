package BOJ_31200

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val minColor = minOf(a, b, c, d)
    println(a + b + c + d - minColor + 1)
}
