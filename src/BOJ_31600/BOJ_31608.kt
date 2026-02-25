package BOJ_31600

fun main() {
    val n = readln().toInt()
    val s = readln()
    val t = readln()
    println((0 until n).count { s[it] != t[it] })
}