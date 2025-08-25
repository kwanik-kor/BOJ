package BOJ_29700

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val (k, x) = readLine()!!.split(" ").map { it.toInt() }

    val left = k - x
    val right = k + x

    var ans = maxOf(0, minOf(b, right) - maxOf(a, left) + 1)

    println(if (ans == 0) "IMPOSSIBLE" else ans)
}