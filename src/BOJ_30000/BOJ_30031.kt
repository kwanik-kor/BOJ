package BOJ_30000

fun main() {
    val n = readLine()!!.toInt()
    val map = mapOf(
        136 to 1000,
        142 to 5000,
        148 to 10000,
        154 to 50000
    )
    println((1..n).sumOf { map[readLine()!!.split(" ").map { it.toInt() }[0]]!! })
}