package BOJ_16500

fun main() {
    val result = generateSequence { readLine() }
        .take(readLine()!!.toInt())
        .map { it.split(" ").sumOf(String::toLong) }
        .sum()
    println(result)
}