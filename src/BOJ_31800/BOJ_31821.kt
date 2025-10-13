package BOJ_31800

fun main() {
    val n = readln().toInt()
    val menus = (1..n).map { readln().toInt() }

    val m = readln().toInt()
    println((1 .. m).sumOf { menus[readln().toInt() - 1] })
}