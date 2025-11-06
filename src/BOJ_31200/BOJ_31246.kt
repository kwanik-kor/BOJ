package BOJ_31200

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var count = 0

    val prices = (0 until n).map { readln().split(" ").map { it.toInt() } }
        .filter { (a, b) ->
            if (a >= b) count++
            a < b
        }
        .map { (a, b) -> b - a }
        .sorted()

    var ans = 0
    for (price in prices) {
        if (count >= k) {
            break
        }

        count++
        ans = price
    }

    println(ans)

}