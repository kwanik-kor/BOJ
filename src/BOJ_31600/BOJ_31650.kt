package BOJ_31600

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val cLine = readln().split(" ").map { it.toInt() }
    val tLine = readln().split(" ").map { it.toInt() }

    val c = IntArray(n) { cLine[it] - tLine[it] }
    c.sort()

    repeat(q) {
        val (v, s) = readln().split(" ").map { it.toInt() }

        var left = -1
        var right = n - 1
        while (left + 1 < right) {
            val mid = (left + right) ushr 1
            if (c[mid] > s) {
                right = mid
            } else {
                left = mid
            }
        }

        println(if (c[right] > s && n - right >= v) "YES" else "NO")
    }
}