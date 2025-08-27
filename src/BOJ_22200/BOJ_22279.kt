package BOJ_22200

fun main() {
    val n = readLine()!!.toInt()
    val result = (0 until n).sumOf {
        val (q, y) = readLine()!!.split(" ").map { it.toDouble() }
        q * y
    }

    println(result)
}