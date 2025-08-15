package BOJ_28400

fun main() {
    val nums = List(5) { readLine()!!.toInt() }
    println(nums.first { n -> nums.count { it == n } % 2 == 1 })
}