package BOJ_21800

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val first = readLine()!!
    val second = readLine()!!

    val x = abs(first[0].toChar() - second[0].toChar())
    val y = abs(first[1].toChar() - second[1].toChar())
    println("${min(x, y)} ${max(x, y)}")
}