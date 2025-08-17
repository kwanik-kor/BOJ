package BOJ_29900

fun main() {
    val (n, h) = readLine()!!.split(" ").map { it.toInt() }
    val result = readLine()!!.split(" ").map { it.toInt() }.count { it <= h }

    println(result)
}