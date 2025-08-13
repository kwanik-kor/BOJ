package BOJ_3000

fun main() {
    val n = readLine()!!.toInt()
    println((n * (n - 1) * (n - 2) * (n - 3)) / 24)
}