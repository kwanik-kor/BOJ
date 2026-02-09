package BOJ_03800

fun main() {
    val sb = StringBuilder()
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break

        val calls = Array(n) {
            val (_, _, start, duration) = readln().split(" ").map { it.toLong() }
            start to start + duration
        }

        repeat(m) {
            val (qs, qd) = readln().split(" ").map { it.toLong() }
            val qEnd = qs + qd
            var count = 0
            for ((cStart, cEnd) in calls) {
                if (minOf(cEnd, qEnd) - maxOf(cStart, qs) >= 1) count++
            }
            sb.appendLine(count)
        }
    }
    print(sb)
}