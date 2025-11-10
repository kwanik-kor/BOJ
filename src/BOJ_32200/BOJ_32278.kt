package BOJ_32200

fun main() {
    val n = readln().toLong()
    println(when {
        n >= Short.MIN_VALUE && n <= Short.MAX_VALUE -> "short"
        n >= Int.MIN_VALUE && n <= Int.MAX_VALUE -> "int"
        else -> "long long"
    })
}