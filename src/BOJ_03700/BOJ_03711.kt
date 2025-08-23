package BOJ_03700

fun solve() {
    val g = readLine()!!.toInt()
    val inputs = IntArray(g) { readLine()!!.toInt() }
    if (g == 1) {
        println(1)
        return
    }

    val checker = IntArray(1000000);
    var ans = 2
    while (true) {
        var check = true
        for (value in inputs) {
            val next = value % ans
            if (checker[next] == ans) {
                check = false
                break
            }
            checker[next] = ans
        }

        if (check) {
            println(ans)
            return
        }

        ans++
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
        solve()
    }
}