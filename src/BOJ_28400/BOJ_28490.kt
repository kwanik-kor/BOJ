package BOJ_28400

fun main() {
    val n = readln().toInt()
    println(
        (0 until n).maxOf { readln().split(" ").let { it[0].toInt() * it[1].toInt() } }
    )
}