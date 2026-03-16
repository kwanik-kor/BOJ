package BOJ_33100

fun main() {
    val x = readln().toInt()
    println((x / 2) + if (x % 2 == 0) 0 else 3)
}
