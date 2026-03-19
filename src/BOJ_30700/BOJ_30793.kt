package BOJ_30700

fun main() {
    val (p, r) = readln().split(" ").map { it.toDouble() }
    val v = p / r
    println(
        when {
            v < 0.2 -> "weak"
            v < 0.4 -> "normal"
            v < 0.6 -> "strong"
            else -> "very strong"
        }
    )
}
