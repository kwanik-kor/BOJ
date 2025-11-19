package BOJ_27200

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    val (s, t) = readln().split(" ").map { it.toInt() }
    val start = minOf(s, t)
    val end = maxOf(s, t)
    when {
        start >= a + 1 && end <= b - 1 -> println("City")
        start <= a && end <= a || start >= b && end >= b -> println("Outside")
        else -> println("Full")
    }
}