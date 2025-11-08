package BOJ_11300

fun main() {
    val fibo = generateSequence(Pair(1L, 1L)) { (a, b) -> Pair(b, a + b) }
        .map { it.first }
        .take(50)
        .toList()

    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) {
            return
        }

        println(if (a == 0 && b == 0) 0 else fibo[c - 1] * a + fibo[c] * b)
    }

}