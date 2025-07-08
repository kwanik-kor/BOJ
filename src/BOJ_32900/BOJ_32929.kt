package BOJ_32900

fun main(args: Array<String>) {
    when (readLine()?.toInt()?.rem(3)) {
        1 -> println("U")
        2 -> println("O")
        0 -> println("S")
    }
}