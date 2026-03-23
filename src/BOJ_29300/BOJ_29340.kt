package BOJ_29300

fun main() {
    val (a, b) = (0 until 2).map { readln() }
    a.zip(b) { x, y -> print(maxOf(x, y)) }
}
