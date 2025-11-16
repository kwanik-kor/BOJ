package BOJ_32700

fun main() {
    val n = readln().toInt()
    var ans = (2 .. 9).any { n % it == 0 && n / it <= 9 }
    println(if (ans) 1 else 0)
}