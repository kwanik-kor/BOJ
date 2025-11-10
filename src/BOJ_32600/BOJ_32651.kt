package BOJ_32600

fun main() {
    val n = readln().toInt()
    println(if (n <= 100_000 && n % 2024 == 0) "Yes" else "No")
}