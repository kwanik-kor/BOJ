package BOJ_32300

fun main() {
    val a = readLine()!!.toInt()
    val (w, v) = readLine()!!.split(" ").map { it.toInt() }
    println(if (w / v >= a) 1 else 0)
}