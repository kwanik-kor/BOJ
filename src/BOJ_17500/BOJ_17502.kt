package BOJ_17500

fun main() {
    val n = readLine()!!.toInt()
    val str1 = readLine()!!.toCharArray()
    var str2 = str1.reversed()

    for (i in 0 until n) {
        when {
            str1[i] == '?' && str2[i] == '?' -> print('a')
            str1[i] == '?' -> print(str2[i])
            else -> print(str1[i])
        }
    }
}