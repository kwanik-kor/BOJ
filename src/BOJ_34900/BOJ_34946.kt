package BOJ_34900

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val shuttle = a + b <= d
    val walk = c <= d
    println(
        when {
            shuttle && walk -> "~.~"
            shuttle -> "Shuttle"
            walk -> "Walk"
            else -> "T.T"
        }
    )
}