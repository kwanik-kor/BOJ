package BOJ_34700

fun main() {
    val (h1, m1) = readln().split(":")
    val (h2, m2) = readln().split(":")
    println(if (h1 < h2 || (h1 == h2 && m1 <= m2)) "YES" else "NO")
}
