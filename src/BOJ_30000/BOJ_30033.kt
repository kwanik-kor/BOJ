package BOJ_30000

fun main() {
    val n = readln().toInt()
    val plans = readln().split(" ").map { it.toInt() }
    val actual = readln().split(" ").map { it.toInt() }

    println((0 until n).count { plans[it] <= actual[it] })
}