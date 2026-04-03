package BOJ_30100

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, a, d) = readln().split(" ").map { it.toInt() }
        println((1 until n).fold(a to a) { (v, sum), _ -> v + d to sum + v + d }.second)
    }
}
