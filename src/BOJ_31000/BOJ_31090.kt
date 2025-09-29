package BOJ_31000

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val remainder = n % 100
        println(if ((n + 1) % remainder == 0) "Good" else "Bye")
    }
}