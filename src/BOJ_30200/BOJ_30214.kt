package BOJ_30200

fun main() {
    val (first, second) = readln().split(" ").map { it.toInt() }
    println(if (first * 2 >= second) "E" else "H")
}