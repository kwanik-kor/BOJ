package BOJ_10800

import java.util.StringTokenizer

fun main() {
    val answers = arrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)

    val n = readLine()!!.toInt()
    repeat(n) { idx ->
        val st = StringTokenizer(readLine()!!, " ")
        var cheater = true
        repeat(10) { q ->
            if (st.nextToken().toInt() != answers[q]) {
                cheater = false
                return@repeat
            }
        }
        if (cheater) println(idx + 1)
    }
}