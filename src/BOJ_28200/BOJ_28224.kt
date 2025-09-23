package BOJ_28200

fun main() {
    val n = readLine()!!.toInt()
    println((0 until n).sumOf { readLine()!!.toInt() })
}