package BOJ_33900

fun main() {
    val (x, y) = readln().split(" ").map {
        val n = it.toInt()
        (0 until n).fold(0) { acc, i -> acc * 10 + 1 }
    }

    println(x + y)
}