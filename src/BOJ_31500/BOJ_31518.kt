package BOJ_31500

fun main() {
    readln()
    println(if ((0 until 3).all { readln().split(" ").map { it.toInt() }.contains(7) }) "777" else "0")
}
