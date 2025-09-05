package BOJ_26900

import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()

    val tuitions = readLine()!!.split(" ").map { it.toLong() }.sorted()
    var max = 0L
    var last = 0L
    var tuition = 0L

    for (i in tuitions.indices) {
        if (tuitions[i] == last) continue

        last = tuitions[i]
        val temp = last * (n - i)
        if (temp > max) {
            max = temp
            tuition = last
        }
    }

    println("$max $tuition")
}