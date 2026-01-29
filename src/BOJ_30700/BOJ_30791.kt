package BOJ_30700

fun main() = with(readln().split(" ").map { it.toInt() }.sorted()) {
    println((0 .. 3).count { last() - this[it] <= 1000 })
}