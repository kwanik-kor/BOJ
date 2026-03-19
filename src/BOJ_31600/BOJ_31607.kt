package BOJ_31600

fun main() {
    val inputs = (0 until 3).map { readln().toInt() }.sorted()
    println(if (inputs[2] == inputs[1] + inputs[0]) 1 else 0)
}
