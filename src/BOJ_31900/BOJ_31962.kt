package BOJ_31900

fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    var ans = -1
    repeat(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        if (s + t <= x) {
            ans = maxOf(ans, s)
        }
    }
    println(ans)
}