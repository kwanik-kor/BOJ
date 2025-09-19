package BOJ_20300

fun main() {
    val n = readLine()!!.toInt()
    val inputs = Array(n) { readLine()!! }

    val output = inputs[0].split(" ")
    for (str in output) { println(str) }
}