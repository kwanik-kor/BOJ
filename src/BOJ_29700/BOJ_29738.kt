package BOJ_29700

fun main() {
    repeat(readLine()!!.toInt()) { idx ->
        val input = readLine()!!.toInt()

        when {
            input > 4500 -> println("Case #${idx + 1}: Round 1")
            input > 1000 -> println("Case #${idx + 1}: Round 2")
            input > 25 -> println("Case #${idx + 1}: Round 3")
            else -> println("Case #${idx + 1}: World Finals")
        }
    }
}