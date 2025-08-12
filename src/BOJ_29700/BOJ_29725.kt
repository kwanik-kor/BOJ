package BOJ_29700

fun main() {
    val score = (0 until 8).sumOf {
        val row = readLine()!!
        row.sumOf { ch ->
            val v = when (ch.uppercaseChar()) {
                'Q' -> 9
                'R' -> 5
                'B', 'N' -> 3
                'P' -> 1
                else -> 0
            }
            if (ch.isUpperCase()) v else -v
        }
    }
    println(score)
}
