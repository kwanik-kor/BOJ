package BOJ_31200

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    println(((b + a) * a + a) * a)
}
