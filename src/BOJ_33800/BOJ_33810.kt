package BOJ_33800

fun main() {
    val origin = "SciComLove"
    val input = readLine()!!
    var count = 0
    for (i in input.indices) {
        if (input[i] != origin[i]) {
            count++
        }
    }
    println(count)
}