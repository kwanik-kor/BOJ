package BOJ_32200

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }

    println(m * (k + 1))
}