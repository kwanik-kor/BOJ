package BOJ_15600

import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    println((sqrt((4 * n - 3).toDouble()).toInt() - 1) / 2)
}