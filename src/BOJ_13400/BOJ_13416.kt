package BOJ_13400

fun main() {
    fun solve() {
        val t = readLine()!!.toInt()
        var tot = 0

        repeat(t) {
            tot += readLine()!!.split(" ").maxOfOrNull { it.toInt() }?.coerceAtLeast(0) ?: 0
        }

        println(tot)
    }

    repeat(readLine()!!.toInt()) {
        solve()
    }
}