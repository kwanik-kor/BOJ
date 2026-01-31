package BOJ_31000

fun main() {
    val factorials = intArrayOf(1, 2, 6, 4, 0, 0, 0, 0, 0, 0)
    repeat(readln().toInt()) { println(factorials[readln().toInt() - 1]) }
}