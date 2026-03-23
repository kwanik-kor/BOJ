package BOJ_28900

fun main() {
    val (h, l, a, b) = readln().split(" ").map { it.toDouble() }
    println(if ((h >= a / 2 && l >= b) || (h >= b / 2 && l >= a)) "YES" else "NO")
}
