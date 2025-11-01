package BOJ_32000

fun main() {
    val h = readln().toInt() * 100
    val m = readln().toInt() * 100
    println(minOf(h, m) / 2)
}