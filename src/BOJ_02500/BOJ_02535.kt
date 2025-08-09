package BOJ_02500

fun main() {
    val n = readLine()!!.toInt()
    val inputs = List(n) { Participant(readLine()!!.split(" ").map { it.toInt() }) }.sortedByDescending { it.score }
    val counts = IntArray(inputs.maxOf { it.country } + 1)

    var printed = 0

    inputs.asSequence()
        .filter { counts[it.country] < 2 }
        .onEach { counts[it.country]++ }
        .take(3)
        .forEach { println("${it.country} ${it.student}") }
}

data class Participant(
    val country: Int,
    val student: Int,
    val score: Int,
) {
    constructor(values: List<Int>): this (
        values[0],
        values[1],
        values[2]
    )
}