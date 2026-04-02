package BOJ_29500

fun main() {
    val n = readln().toInt()
    val files = (0 until n).map { readln() }
    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        (a .. b).forEach { println(files[it - 1]) }
    }
}
