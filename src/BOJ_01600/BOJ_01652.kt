package BOJ_01600

fun countLine(line: String): Int =
    line.split('X').count { it.length >= 2}

fun countAll(n: Int, map: List<String>): Pair<Int, Int> {
    val h = map.sumOf { countLine(it) }
    val v = (0 until n).sumOf { col ->
        countLine(map.joinToString("") { it[col].toString() })
    }
    return h to v
}

fun main() {
    val n = readLine()!!.toInt()
    val map = List(n) { readLine()!! }
    val (h, v) = countAll(n, map)
    println("$h $v")
}
