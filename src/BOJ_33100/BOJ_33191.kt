package BOJ_33100

fun main() {
    val b = readln().toInt()
    val fruits = listOf("Watermelon", "Pomegranates", "Nuts")
    val ans = (0 until 3)
        .map { fruits[it] to readln().toInt() }
        .firstOrNull { b >= it.second }
    println(ans?.first ?: "Nothing")
}
