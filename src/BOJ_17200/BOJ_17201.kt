package BOJ_17200

fun main() {
    // + 1 / - 2
    val n = readln().toInt()
    val input = readln()
    println(if ((0 until n).all { input[it * 2] == input[0] }) "Yes" else "No")
}
