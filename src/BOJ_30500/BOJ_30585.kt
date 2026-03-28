package BOJ_30500

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val ones = List(h) { readln() }.sumOf { it.count { c -> c == '1' } }
    println(minOf(ones, h * w - ones))
}
