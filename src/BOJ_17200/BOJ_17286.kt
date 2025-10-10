package BOJ_17200

import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    var (x, y) = readLine()!!.split(" ").map { it.toDouble() }
    val points = (0 until 3).map { readLine()!!.split(" ").map { it.toDouble() } }
    val visits = BooleanArray(3) { false }
    var ans = Double.MAX_VALUE

    fun backtracking(cnt: Int, distance: Double) {
        if (cnt == 3) ans = min(ans, distance)

        for (i in 0 until 3) {
            if (visits[i]) continue

            visits[i] = true
            val (tempX, tempY) = x to y
            val newDist = sqrt((tempX - points[i][0]) * (tempX - points[i][0]) + (tempY - points[i][1]) * (tempY - points[i][1]))
            x = points[i][0]
            y = points[i][1]
            backtracking(cnt + 1, distance + newDist)
            x = tempX
            y = tempY
            visits[i] = false
        }
    }

    backtracking(0, 0.0)

    println(ans.toInt())
}

