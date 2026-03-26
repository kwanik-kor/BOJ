package BOJ_33700

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val t = readln().toInt()
    println(
        when {
            t <= 30 -> a
            else -> a + (t - 30 + b - 1) / b * c
        }
    )
}
