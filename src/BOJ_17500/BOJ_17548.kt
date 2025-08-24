package BOJ_17500

fun main() {
    val input = readLine()!!
    val ez = buildString {
        repeat((input.length - 2) * 2) { append('e') }
    }

    println("h${ez}y")
}