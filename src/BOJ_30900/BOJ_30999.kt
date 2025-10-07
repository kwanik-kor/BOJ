package BOJ_30900

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    println (
        (0 until n).count {
            readLine()!!.toCharArray().count { it == 'O' } > (m /2)
        }
    )
}