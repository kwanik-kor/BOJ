package BOJ_03900

fun main() {
    var t = readLine()!!.toInt()
    repeat(t) {
        val input = readLine()!!.split(" ")
        val b = input[0].toInt()
        println(input[1].toCharArray().sumOf { it.digitToInt()  }% (b - 1))
    }
}