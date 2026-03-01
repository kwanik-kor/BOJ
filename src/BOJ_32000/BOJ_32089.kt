package BOJ_32000

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break

        val i = readln().split(" ").map { it.toInt() }
        val result = i.foldIndexed(0 to 0) { idx, (prev, max), value ->
            val graduated = if (idx >= 3) i[idx - 3] else 0
            val cur = prev + value - graduated
            cur to maxOf(max, cur)
        }.second
        println(result)
    }
}