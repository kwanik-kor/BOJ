package BOJ_31200

/**
 * 0..641
 * 연속되는 숫자 그룹의 최소 개수
 */
fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.map { it.digitToInt() }

    val (count, last) = nums.foldIndexed(0 to 0) { _, (cnt, temp), digit ->
        val next = temp * 10 + digit
        if (next > 641) {
            val newCnt = cnt + if (digit == 0) 2 else 1
            newCnt to digit
        } else {
            cnt to next
        }
    }

    val result = count + if (last != 0) 1 else 0
    println(result)
}