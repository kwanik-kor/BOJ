package BOJ_29800

fun main() {
    val sleep = readln().toInt()
    val alarm = readln().toInt()
    println(if (sleep > 12) 24 - sleep + alarm else alarm - sleep)
}