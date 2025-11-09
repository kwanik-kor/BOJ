package BOJ_02600

fun main() {
    val n = readln().toInt()
    var maxLength = 1
    var ansIdx = 0

    fun findSequence(prev: Int, next: Int, print: Boolean = false): Int {
        return generateSequence(prev to next) { (a, b) -> b to a - b}
            .map {
                if (print) print("${it.first} ")
                it.second
            }
            .takeWhile { it >= 0 }
            .count() + 1
    }

    (0 .. n).forEach {
        val length = findSequence(n, it)
        if (length > maxLength) {
            maxLength = length
            ansIdx = it
        }
    }

    println(maxLength)
    findSequence(n, ansIdx, true)
}