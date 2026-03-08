package BOJ_07700

fun main() {
    val n = readln().toInt()
    val (b1, b2) = readln().split(" ").map { it.toInt() }
    println(if((0 until n).any {
        val input = readln().split(" ").map { it.toInt() }
        input[0] <= b1 && b1 <= input[2] && input[1] <= b2 && b2 <= input[3]
    }) "Yes" else "No")
}
