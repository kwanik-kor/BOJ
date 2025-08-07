package BOJ_02000

fun main() {
    val n = readLine()!!.toLong()
    var factorials = generateSequence(Pair(1L, 0)) { (fact, i) ->
        Pair(fact * (i + 1), i + 1)
    }
        .map { it.first }
        .takeWhile { it <= n }
        .toList()

    var isPossible = (1 until (1 shl factorials.size)).any { mask ->
        factorials.withIndex().sumOf { (idx, value) ->
            if ((mask and (1 shl idx)) != 0) value else 0L
        } == n
    }

    println(if (isPossible) "YES" else "NO")
}