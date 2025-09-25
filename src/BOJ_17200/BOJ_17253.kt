package BOJ_17200

fun main() {
    var n = readLine()!!.toLong()
    var result = true

    if (n == 0L) result = false

    while (n > 0) {
        if (n % 3 == 2L) {
            result = false
            break
        }

        n /= 3
    }

    println(if (result) "YES" else "NO")
}