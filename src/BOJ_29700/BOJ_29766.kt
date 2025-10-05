package BOJ_29700

fun main() {
    val line = readLine()!!
    val count = (0 until line.length - 4).count { line.substring(it, it + 4) == "DKSH" }
    println(count)
}