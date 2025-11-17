package BOJ_32900

fun main() {
    val (t, x) = readln().split(" ").map{ it.toInt() }
    val n = readln().toInt()
    val able = (0 until n).all {
        val a = readln().toInt()
        readln().split(" ").any { it.toInt() == x }
    }

    println(if (able) "YES" else "NO")
}