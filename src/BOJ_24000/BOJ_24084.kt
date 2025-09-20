package BOJ_24000

fun main() {
    val len = readLine()!!.toInt()
    val input = readLine()!!
    for (i in 0 until len - 1) {
        if (input[i + 1] == 'J') {
            println(input[i])
        }
    }
}