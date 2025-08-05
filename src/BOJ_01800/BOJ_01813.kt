package BOJ_01800

fun main() {
    readLine()
    val freq = readLine()!!
        .split(" ").map { it.toInt() }
        .groupingBy { it }.eachCount()
        .toMutableMap()
        .apply { putIfAbsent(0, 0) }

    println(
        freq.keys.sortedDescending().firstOrNull { it == freq[it] } ?: -1
    )
}