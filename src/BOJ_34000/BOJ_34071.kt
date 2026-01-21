package BOJ_34000

fun main() {
    val n = readln().toInt()
    val arr = (0 until n).map { readln().toInt() }
    val (min, max) = arr.min() to arr.max()
    println(if (arr[0] == min) "ez" else if (arr[0] == max) "hard" else "?")
}