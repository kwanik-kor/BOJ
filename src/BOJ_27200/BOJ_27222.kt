package BOJ_27200

fun main() {
    val n = readLine()!!.toInt()
    val days = readLine()!!.split(" ").map { it == "1" }

    var sum = 0
    repeat(n) { idx ->
        val input = readLine()!!.split(" ").map { it -> it.toInt() }
        if (!days[idx] || input[0] >= input[1]) return@repeat

        sum += input[1] - input[0]
    }

    println(sum)
}