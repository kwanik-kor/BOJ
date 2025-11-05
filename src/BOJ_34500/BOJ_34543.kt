package BOJ_34500

fun main() {
    val n = readln().toInt()
    val steps = readln().toInt()
    println(maxOf(0, n * 10 + (if (n >= 3) 20 else 0) + (if (n == 5) 50 else 0) - (if (steps > 1000) 15 else 0)))
}