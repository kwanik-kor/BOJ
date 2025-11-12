package BOJ_32600

fun main() {
    val n = readln().toInt()
    var total = 0L
    var anger = 0L
    readln().split(" ").map { it.toLong() }
        .forEach {
            if (it == 1L) anger++ else anger--
            total += anger
        }

    println(total)
}