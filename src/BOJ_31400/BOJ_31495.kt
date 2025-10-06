package BOJ_31400

fun main() {
    val input = readLine()!!

    if (input.length > 2 && input.startsWith("\"") && input.endsWith("\"")) {
        println(input.substring(1, input.length - 1))
    } else {
        println("CE")
    }
}