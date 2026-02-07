package BOJ_34500

fun main() {
    val m = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    println((0 until n).sumOf {
        val (b, l, s) = readln().split(" ").map { it.toDouble() }
        if (l >= 2.0 && s >= 17) m[b.toInt()] else 0
    })
}