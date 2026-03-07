package BOJ_05000

fun main() {
    val n = readln().toInt()
    println((0 until n).count { !readln().contains("CD") })
}
