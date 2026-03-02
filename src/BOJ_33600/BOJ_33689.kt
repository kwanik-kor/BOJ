package BOJ_33600

fun main() {
    val n = readln().toInt()
    println((0 until n).count { readln().startsWith('C') })
}