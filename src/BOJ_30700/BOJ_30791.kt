package BOJ_30700

fun main() {
    val votes = readln().split(" ").map { it.toInt() }.sorted()
    println((0 .. 3).count { votes[4] - votes[it] <= 1000 })
}