package BOJ_31200

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toBigDecimal() }
    println(listOf(a, b, c).sorted()[1])
}
