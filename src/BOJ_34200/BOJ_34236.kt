package BOJ_34200

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    println(arr.last() + arr[1] - arr[0])
}