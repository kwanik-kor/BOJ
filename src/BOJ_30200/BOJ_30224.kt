package BOJ_30200

fun main() {
    val str = readln()
    val num = str.toInt()

    when {
        !str.contains("7") && num % 7 != 0 -> println(0)
        !str.contains("7") && num % 7 == 0 -> println(1)
        str.contains("7") && num % 7 != 0 -> println(2)
        else -> println(3)
    }
}