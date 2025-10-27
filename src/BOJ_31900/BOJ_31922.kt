package BOJ_31900

fun main() {
    val (a, p, c) = readln().split(" ").map { it.toInt() }
    println(maxOf(a + c, p))
}