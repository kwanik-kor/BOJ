package BOJ_31600

fun main() {
    readln()
    println(
        readln().sumOf { when (it) {
            'j' -> 2
            'o' -> 1
            else -> 2
        }.toInt() }
    )
}