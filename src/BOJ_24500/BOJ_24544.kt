package BOJ_24500

fun main() {
    val n = readln().toInt()
    val scores = readln().split(" ").map { it.toInt() }
    val categories = readln().split(" ").map { it.toInt() }
    println(scores.sum())
    println(scores.zip(categories).filter { (_, c) -> c != 1 }.sumOf { (s, _) -> s })
}