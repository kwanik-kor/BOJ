package BOJ_30100

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln()
        val cnt = input.count { it == 'a' }
        println(minOf(input.length - cnt, cnt))
    }
}
