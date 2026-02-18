package BOJ_34800

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(n / m + if (n != 0 && n % m != 0) 1 else 0)
}