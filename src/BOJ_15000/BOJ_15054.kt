package BOJ_15000

fun main() {
    val (k, n) = readLine()!!.split(" ").map { it.toInt() }
    val inputs = readLine()!!.split(" ").map { it.toInt() }

    val counts = IntArray(k + 1)
    for (i in 0 until inputs.size) {
        counts[inputs[i]]++
    }

    if ((n + 1) % k == 0) {
        val count = (n + 1) / k
        for (i in 1..k) {
            if (counts[i] >= count) continue

            counts[i]++
            if (isCompleteSequence(counts)) {
                println("+$i")
                return
            }
            counts[i]--
        }
    } else if ((n - 1) % k == 0) {
        val count = (n + 1) / k

        for (i in 1..k) {
            if (counts[i] <= count) continue

            counts[i]--
            if (isCompleteSequence(counts)) {
                println("-$i")
                return
            }
            counts[i]++
        }
    } else if (n % k == 0) {
        val count = n / k
        var subtract = 0
        var plus = 0

        for (i in 1..k) {
            if (subtract == 0 && counts[i] > count) {
                subtract = i
                counts[i]--
            }

            if (plus == 0 && counts[i] < count) {
                plus = i
                counts[i]++
            }
        }

        if (isCompleteSequence(counts)) {
            println("-$subtract +$plus")
            return
        }
    }

    println("*")
}

fun isCompleteSequence(counts: IntArray): Boolean {
    val criteria = counts[1]
    for (i in 2 until counts.size) {
        if (counts[i] != criteria) return false
    }
    return true
}
