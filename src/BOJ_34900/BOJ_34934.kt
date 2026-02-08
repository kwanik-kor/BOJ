package BOJ_34900

fun main() {
    val n = readln().toInt()
    val classes = (0 until n).map { readln().split(" ") }
    println(classes.maxBy { it[1].toInt() }[0])
}