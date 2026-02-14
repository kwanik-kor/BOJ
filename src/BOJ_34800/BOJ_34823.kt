package BOJ_34800

fun main() {
    val (y, c, p) = readln().split(" ").map { it.toInt() }
    println(minOf(y, p, c / 2))
}