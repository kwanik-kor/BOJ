package BOJ_34300

fun main() {
    val (n, m, s) = readln().split(" ").map { it.toLong() }
    val p = s * (m + 1) * (100 - n) / 100
    val a = s * m

    println(minOf(p, a))
}