package BOJ_14900

fun main() {
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val gap = arr[2] - arr[0]

    if (gap % arr[1] != 0 || arr[1] * gap < 0) {
        println("X")
    } else {
        println((gap / arr[1]) + 1)
    }
}