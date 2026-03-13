package BOJ_34500

fun main() {
    val principal = listOf(100, 50, 20)
    val unit = readln().split(" ").map { it.toInt() }
    val amount = readln().split(" ").map { it.toInt() }
    println((0 until 3).sumOf { amount[it] / principal[it] * unit[it] })
}
