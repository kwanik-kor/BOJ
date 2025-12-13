package BOJ_33500

fun main() {
    fun hole(char: Char): Int = when (char) {
            'B' -> 2
            'A', 'a', 'b', 'D', 'd', 'e', 'g', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', '@' -> 1
            else -> 0
    }

    println(readln().sumOf { hole(it) })
}