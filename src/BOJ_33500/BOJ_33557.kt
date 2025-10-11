package BOJ_33500

import kotlin.text.digitToInt

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map(String::toLong)
        println(if (a * b == wrongMultiply(a, b)) 1 else 0)
    }
}


fun wrongMultiply(a: Long, b: Long): Long {
    val aStr = a.toString()
    val bStr = b.toString()

    val len = minOf(aStr.length, bStr.length)

    val multiplied = (len - 1 downTo 0)
        .joinToString("") { i ->
            (aStr[aStr.lastIndex - i].digitToInt() * bStr[bStr.lastIndex - i].digitToInt()).toString()
        }

    val prefix = when {
        aStr.length > bStr.length -> aStr.dropLast(len)
        else -> bStr.dropLast(len)
    }

    return (prefix + multiplied).toLong()
}
