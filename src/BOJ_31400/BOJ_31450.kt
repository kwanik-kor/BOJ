package BOJ_31400

fun main() {
    val (m, k) = readln().split(" ").map { it.toInt() }
    println(if(m % k == 0) "Yes" else "No")
}