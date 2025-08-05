package BOJ_01700

tailrec fun String.reduceToSingleDigit(count: Int = 0): Pair<Int, Int> =
    if (length == 1) count to first().digitToInt()
    else sumOf { it.digitToInt() }.toString().reduceToSingleDigit(count + 1)

fun main() {
    var input = readLine()!!
    val (count, last) = input.reduceToSingleDigit()
    println(count)
    println(if (last % 3 == 0) "YES" else "NO")
}