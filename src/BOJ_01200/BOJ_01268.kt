package BOJ_01200

fun main() {
    val n = readLine()!!.toInt()
    val students = Array(n) { readLine()!!.split(" ").map { it.toInt() } }

    val count = IntArray(n)

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue
            for (year in 0 until 5) {
                if (students[i][year] == students[j][year]) {
                    count[i]++
                    break;
                }
            }
        }
    }

    var maxIdx = 0;
    for (i in 1 until n) {
        if (count[i] > count[maxIdx]) {
            maxIdx = i
        }
    }

    println(maxIdx + 1)
}

