package BOJ_03200

fun main() {
    val n = readLine()!!.toInt()
    val inputs = (0 until n).map { readLine()!!.toInt() }.sorted()

    for (i in inputs.indices) {
        if (inputs[i] < i + 1) {
            println(i + 1)
            break
        }
    }
}