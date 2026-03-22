package BOJ_29000

fun main() {
    val (n, m, k, a, b, c) = readln().split(" ").map(String::toLong)

    mapOf("Joffrey" to n * a, "Robb" to m * b, "Stannis" to k * c)
        .let { armies -> armies.filterValues { it == armies.maxOf { (_, v) -> v } } }
        .keys
        .sorted()
        .joinToString(" ")
        .let(::println)
}

private operator fun <T> List<T>.component6(): T = this[5]
