package BOJ_28900

fun main() {
    val start = readln()
    val result = readln().split(" ").sumOf { it.toInt() }
    println(if (result == 0) "Stay" else if (result > 0) "Right" else "Left")
}