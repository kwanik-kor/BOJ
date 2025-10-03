package BOJ_29700

fun main() {
    val promises = setOf(
        "Never gonna give you up",
        "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop",
    )

    val n = readLine()!!.toInt()
    repeat(n) {
        if (!promises.contains(readLine()!!)) {
            println("Yes")
            return
        }
    }
    println("No")
}