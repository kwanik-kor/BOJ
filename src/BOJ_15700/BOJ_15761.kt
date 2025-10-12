package BOJ_15700

fun main() {
    val n = readln().toInt()
    val cows = readln().split(" ").map { it.toInt() }.sorted().reversed()

    val cnt = cows
        .withIndex()
        .takeWhile { (idx, w) -> w >= idx }
        .count()

    println(cnt)
}