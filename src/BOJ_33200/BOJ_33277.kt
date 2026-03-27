package BOJ_33200

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val p = 60 * 24 * m / n
    println("%02d:%02d".format(p / 60, p % 60))
}
