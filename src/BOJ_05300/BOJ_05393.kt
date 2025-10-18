package BOJ_05300

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(((n + 1) / 2 - (n + 2) / 6) + (n - (n / 2)))
    }
}