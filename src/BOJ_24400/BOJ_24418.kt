package BOJ_24400

import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val map = List(n) { readLine()!!.split(" ").map { it.toInt() } }
    var cnt = 0

    fun recursive(i: Int, j: Int): Int {
        if (i == -1 || j == -1) {
            cnt++
            return 0
        }
        return map[i][j] + max(recursive(i, j - 1), recursive(i - 1, j))
    }

    recursive(n - 1, n - 1)

    println("$cnt ${n * n}")
}