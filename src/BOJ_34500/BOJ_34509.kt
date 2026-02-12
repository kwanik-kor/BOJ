package BOJ_34500

fun main() {
    println((10 .. 99).find {
        val str = it.toString()

        !str.contains('8') && str.reversed().toInt() % 4 == 0 && str.sumOf { c -> c.digitToInt() } % 6 == 0
    })
}