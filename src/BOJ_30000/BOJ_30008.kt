package BOJ_30000

import java.util.StringTokenizer

fun grade(rank: Int): Int = when (rank) {
    in 0..4 -> 1
    in 5..11 -> 2
    in 12..23 -> 3
    in 24..40 -> 4
    in 41..60 -> 5
    in 61..77 -> 6
    in 78..89 -> 7
    in 90..96 -> 8
    else -> 9
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val line = StringTokenizer(readLine()!!)

    for (i in 0 until k) {
        print(grade(line.nextToken().toInt() * 100 / n))
        if (i != k - 1) print(" ")
    }
}