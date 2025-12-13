package BOJ_33500

fun main() {
    fun hole(char: Char): Int = when (char) {
            'A', 'a', 'B' -> 2
            'b', 'D', 'd', 'e', 'g', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', '@' -> 1
            else -> 0
    }

    println(readln().sumOf { hole(it) })
}