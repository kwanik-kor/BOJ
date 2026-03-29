package BOJ_29800

fun main() {
    readln()
    val (x, y) = readln().fold(0 to 0) { (x, y), c ->
        when (c) {
            'N' -> x to y + 1
            'S' -> x to y - 1
            'E' -> x + 1 to y
            else -> x - 1 to y
        }
    }
    println(kotlin.math.abs(x) + kotlin.math.abs(y))
}
