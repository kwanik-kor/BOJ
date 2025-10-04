package BOJ_30800

fun main() {
    val t = readLine()!!.toInt()
    val five = "++++"
    val one = "|"
    repeat(t) {
        val n = readLine()!!.toInt()
        repeat(n / 5) {
            print("$five ")
        }

        repeat(n % 5) {
            print(one)
        }
        println()
    }
}