package BOJ_29600

fun main() {
    val (n, a) = readln().split(" ").map { it.toInt() }
    println(readln().split(" ").sumOf { it.toInt() / a })
}
