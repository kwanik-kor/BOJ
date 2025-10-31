package BOJ_14500

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val spotty = (0 until n).map { readln() }
    val plain = (0 until n).map { readln() }

    var cnt = 0
    (0 until m).forEach { col ->
        val sg = (0 until n).map { row -> spotty[row][col] }.toSet()
        val pg = (0 until n).map { row -> plain[row][col] }.toSet()
        if (sg.intersect(pg).isEmpty()) {
            cnt++
        }
    }

    println(cnt)
}