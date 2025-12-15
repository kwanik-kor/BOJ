package BOJ_31600

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(if (a + b == c) "correct!" else "wrong!")
}