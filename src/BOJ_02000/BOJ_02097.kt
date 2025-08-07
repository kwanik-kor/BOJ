package BOJ_02000

import kotlin.math.round
import kotlin.math.sqrt

/**
 * 3 1
 * 4 2 -> 4
 * 5 2 -> 2, 1 -> 6
 * 6 2 -> 2, 1 -> 6
 * 7 2 -> 2, 2 -> 8
 * 8 2 -> 2, 2 -> 8
 * 9 3 -> 2, 2 -> 8
 */
fun main() {
    val n = readLine()!!.toInt()
    if (n == 1 || n == 2) {
        println("4")
        return
    }

    val sqrt = round(sqrt(n.toDouble())).toInt()
    if (sqrt * sqrt >= n) {
        println((sqrt - 1) * 4)
    } else {
        println((sqrt * 2 - 1) * 2)
    }
}