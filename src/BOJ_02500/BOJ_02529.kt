package BOJ_02500

fun main() {
    val k = readLine()!!.toInt()

    val input = readLine()!!.split(" ")
    val flags = BooleanArray(10) { false }

    var min = ""
    var max = ""

    fun backtracking(len: Int, str: String) {
        if (len == k + 1) {
            max = str
            if (min == "") {
                min = str
            }

            return
        }

        for (i in 0 until 10) {
            if (flags[i]) continue

            if (len == 0 || isAvailable(input[len - 1], str[len - 1].digitToInt(), i)) {
                flags[i] = true
                backtracking(len + 1, str + i)
                flags[i] = false
            }
        }
    }

    backtracking(0, "")

    println("$max\n$min")
}

fun isAvailable(sign: String, a: Int, b: Int): Boolean =
    when {
        sign == "<" -> a < b
        else -> a > b
    }