package BOJ_30000

infix fun String.containsAnyOf(patterns: List<String>) =
    patterns.any { this.contains(it) }

fun main() {
    val n = readln().toInt()
    println((0 until n).count {
        val input = readln()
        input containsAnyOf listOf("01", "OI")
    })
}