package BOJ_02000

import java.util.PriorityQueue

fun main() {
    val n = readLine()!!.toInt()
    val pos = PriorityQueue<Long>(compareByDescending { it })
    val neg = PriorityQueue<Long>()

    var one = 0L
    repeat(n) {
        val input = readLine()!!.toLong()
        when  {
            input == 1L -> one++
            input > 0L -> pos += input
            else -> neg += input
        }
    }

    var ans = 0L
    while (pos.isNotEmpty()) {
        val num = pos.poll()
        val num2 = if (pos.isEmpty()) 1 else pos.poll()
        ans += num * num2
    }

    while (neg.isNotEmpty()) {
        val num = neg.poll()
        val num2 = if (neg.isEmpty()) 1 else neg.poll()
        ans += num * num2
    }
    ans += one

    println(ans)
}