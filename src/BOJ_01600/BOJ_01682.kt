package BOJ_01600

fun String.exchange(option: Int): String {
    val idx = when (option) {
        0 -> intArrayOf(7, 6, 5, 4, 3, 2, 1, 0)
        1 -> intArrayOf(3, 0, 1, 2, 5, 6, 7, 4)
        2 -> intArrayOf(0, 2, 5, 3, 4, 6, 1, 7)
        else -> intArrayOf(4, 1, 2, 3, 0, 5, 6, 7)
    }
    return String(CharArray(8) { this[idx[it]] })
}

fun main() {
    val target = readln().replace(" ", "")
    val start = "12345678"

    val visited = mutableSetOf(start)
    val queue = ArrayDeque(listOf(start))

    var depth = 0
    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val cur = queue.removeFirst()
            if (cur == target) {
                println(depth)
                return
            }

            (0..3).map { cur.exchange(it) }
                .filter { it !in visited }
                .forEach {
                    visited += it
                    queue += it
                }
        }
        depth++
    }
}