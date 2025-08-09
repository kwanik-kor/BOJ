package BOJ_02600

fun main() {
    val (h, v) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(2) { mutableListOf<Int>() }
    map[0].add(0)
    map[0].add(v)
    map[1].add(0)
    map[1].add(h)

    repeat(readLine()!!.toInt()) {
        val (type, loc) = readLine()!!.split(" ").map { it.toInt() }
        map[type].add(loc)
    }

    map[0].sort()
    map[1].sort()

    var hLen = 0
    for (i in 0 until map[0].size - 1) {
        hLen = maxOf(hLen, map[0][i + 1] - map[0][i])
    }

    var vLen = 0
    for (i in 0 until map[1].size - 1) {
        vLen = maxOf(vLen, map[1][i + 1] - map[1][i])
    }

    println(hLen * vLen)
}