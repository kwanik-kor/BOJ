package BOJ_31800

fun main() {
    val subject = readln().substring(0, 5)
    val n = readln().toInt()

    println((0 until n).count { readln().substring(0, 5) == subject })
}