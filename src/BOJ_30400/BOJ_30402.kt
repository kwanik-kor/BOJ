package BOJ_30400

fun main() {
    val names = mapOf(
        "w" to "chunbae",
        "b" to "nabi",
        "g" to "yeongcheol"
    )

    repeat(15) {
        val token = readLine()!!
            .split(" ")
            .firstOrNull { it in names.keys }

        token?.let {
            println(names[it])
            return
        }
    }
}