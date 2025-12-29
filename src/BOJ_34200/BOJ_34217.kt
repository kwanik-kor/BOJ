package BOJ_34200

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val (c, d) = readln().split(" ").map { it.toInt() }
    println(if (a + c < b + d) "Hanyang Univ." else if (a + c > b + d) "Yongdap" else "Either")
}