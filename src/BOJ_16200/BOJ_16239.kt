package BOJ_16200

fun main() {
    var k = readLine()!!.toInt()
    val n = readLine()!!.toInt()

    var num = 0
    repeat(n) { idx ->
        if (idx == n - 1) {
            println(k)
            return@repeat
        }

        k -= ++num
        println(num)
    }
}