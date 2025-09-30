package BOJ_30700

fun main() {
    val scores = mapOf(
        "miss" to 0,
        "bad" to 200,
        "cool" to 400,
        "great" to 600,
        "perfect" to 1000
    )

    val input = readLine()!!.split(" ")
    println(input[0].toInt() * scores[input[1]]!!)
}