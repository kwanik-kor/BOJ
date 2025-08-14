package BOJ_02800

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val j = readLine()!!.toInt()

    var left = 1
    var right = m
    var cnt = 0
    repeat(j) {
        val pos = readLine()!!.toInt()

        if (left <= pos && pos <= right) {
            return@repeat
        }

        if (pos < left) {
            cnt += left - pos
            right -= left - pos
            left = pos
        } else {
            cnt += pos - right
            left += pos - right
            right = pos
        }
    }

    println(cnt)
}