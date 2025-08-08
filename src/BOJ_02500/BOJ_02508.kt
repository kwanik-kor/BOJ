package BOJ_02500

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) { solve() }
}

fun solve() {
    readLine()
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }

    val map = List(r) { readLine()!! }
    var sum = map.sumOf { countCandy(it, c) }
    sum += (0 until c).sumOf { col ->
        val colStr = buildString(r) {
            for (row in 0 until r) {
                append(
                    when (val ch = map[row][col]) {
                        'v' -> '>'
                        '^' -> '<'
                        '>' -> 'v'
                        '<' -> '^'
                        else -> ch
                    }
                )
            }
        }
        countCandy(colStr, r)
    }

    println(sum)
}

fun countCandy(line: String, columns: Int): Int =
    generateSequence(0) { i ->
            if (line.regionMatches(i, ">o<", 0, 3, ignoreCase = false)) i + 3 else i + 1
        }
        .takeWhile { it <= columns - 3 }
        .count { line.regionMatches(it, ">o<", 0, 3, ignoreCase = false) }