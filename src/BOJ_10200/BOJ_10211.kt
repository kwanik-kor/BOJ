package BOJ_10200

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val arr = listOf(0) + readLine()!!.split(" ").map { it.toInt() }
        val dp = IntArray(arr.size + 1)
        var ans = Integer.MIN_VALUE

        for (i in 1..arr.lastIndex) {
            dp[i] = maxOf(arr[i] + dp[i - 1], arr[i])
            ans = maxOf(ans, dp[i])
        }

        println(ans)
    }
}