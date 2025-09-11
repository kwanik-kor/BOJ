package BOJ_23900

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val array = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()

    var count = 0
    for (last in n downTo 1) {
        for (i in 0 until  last - 1) {
            if (array[i] > array[i + 1]) {
                val temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp

                if (++count == k) {
                    println(array.joinToString(" "))
                    return
                }
            }
        }
    }

    println(-1)
}