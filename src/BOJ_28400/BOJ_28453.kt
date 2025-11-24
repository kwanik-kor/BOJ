package BOJ_28400

fun main() {
    fun section(level: Int): Int = when {
        level == 300 -> 1
        level >= 275 && level < 300 -> 2
        level >= 250 && level < 275 -> 3
        else -> 4
    }

    readln()
    println(readln().split(" ").map { section(it.toInt()) }.joinToString(" "))

}