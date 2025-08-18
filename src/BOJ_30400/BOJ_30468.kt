package BOJ_30400

fun main() {
    val (str, dex, int, luk, n) = readLine()!!.split(" ").map { it.toInt() }
    println(maxOf(0, 4 * n - (str + dex + int + luk)))
}