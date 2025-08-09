package BOJ_02600

fun main() {
    val cnt = readLine()!!.toInt()
    var result = 0
    for (i in 1..cnt) {
        for (j in i..cnt - i) {
            val k = cnt - i - j;
            if (k < j) continue

            val max = maxOf(i, j, k)
            if (cnt - max > max) {
                result++
            }
        }
    }
    println(result)
}