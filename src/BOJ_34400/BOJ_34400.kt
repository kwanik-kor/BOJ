package BOJ_34400

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val remainder = (readLine()!!.toInt() * 60 + 30) % (25 * 60)
        println(if (remainder > 0 && remainder <= 17 * 60) "ONLINE" else "OFFLINE")
    }
}