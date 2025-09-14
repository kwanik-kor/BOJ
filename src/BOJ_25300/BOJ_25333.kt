package BOJ_25300

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (a, b, x) = readLine()!!.split(" ").map { it.toInt() }
        println("${x / gcd(a, b)}")
    }
}