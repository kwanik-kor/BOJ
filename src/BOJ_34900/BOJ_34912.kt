package BOJ_34900

fun main() {
    val (a, t) = readln().split(" ").map { it.toInt() }
    println(maxOf(10 + 2 * (25 - a + t), 0))
}