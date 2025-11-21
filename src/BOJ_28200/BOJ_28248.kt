package BOJ_28200

fun main() {
    val p = readln().toInt()
    val c = readln().toInt()

    println(p * 50 + c * (-10) + if (p > c) 500 else 0)
}