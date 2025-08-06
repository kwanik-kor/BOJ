package BOJ_02000

fun main() {
    val n = readLine()!!.toInt()

    var left = 1
    var right = 1
    var sum = 1
    var cnt = 0

    while (left <= n) {
        when {
            sum < n -> {
                right++
                sum += right
            }
            sum == n -> {
                cnt++
                sum -= left++
            }
            else -> sum -= left++
        }
    }

    println(cnt)
}