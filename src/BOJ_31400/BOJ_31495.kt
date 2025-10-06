package BOJ_31400

fun main() {
    val input = readLine()!!

    println(if (input.startsWith("\"") && input.endsWith("\"")) input.substring(1, input.length - 1) else "CE")
}