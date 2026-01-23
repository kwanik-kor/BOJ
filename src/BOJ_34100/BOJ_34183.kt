package BOJ_34100

fun main() {
    val (n, m, a, b) = readln().split(" ").map { it.toInt() }

    println(if (n * 3 <= 3) 0 else (n * 3 - m) * a + b)
}