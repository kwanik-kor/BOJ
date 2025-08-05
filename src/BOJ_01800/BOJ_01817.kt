package BOJ_01800

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    if (n == 0) return println(0)

    val weights = readLine()!!.split(" ").map { it.toInt() }
    println(
        weights.fold(1 to 0) { (box, curr), w ->
            if (curr + w <= m) box to curr + w
            else box + 1 to w
        }.first
    )
}