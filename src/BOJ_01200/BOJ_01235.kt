package BOJ_01200

fun main() {
    val n = readLine()!!.toInt()
    val inputs = (0 until n).map { readLine()!!.reversed() }
    var length = minLength(n)

    while (true) {
        val set = mutableSetOf<String>()
        for (i in 0 until n) {
            set += inputs[i].substring(0, length)
        }

        if (set.size == n) break
        else length++
    }

    println(length)
}

fun minLength(n: Int): Int {
    return when {
        n < 10 -> 1
        n < 100 -> 2
        n < 1000 -> 3
        else -> 4
    }
}