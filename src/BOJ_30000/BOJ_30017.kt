package BOJ_30000

fun main() {
    val (patty, cheese) = readLine()!!.split(" ").map { it.toInt() }
    if (patty <= cheese) {
        println(patty * 2 - 1)
    } else {
        println(cheese * 2 + 1)
    }
}