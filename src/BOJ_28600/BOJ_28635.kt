package BOJ_28600

fun main() {
    val m = readln().toInt()
    val a = readln().toInt()
    val b = readln().toInt()
    println((b - a + m) % m)
}