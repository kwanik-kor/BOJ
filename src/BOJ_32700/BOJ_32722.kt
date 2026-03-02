package BOJ_32700

fun main() {
    val road = listOf(
        listOf(1, 3), listOf(6, 8), listOf(2, 5)
    )
    println(if ((0 until 3).all { readln().toInt() in road[it] }) "JAH" else "EI")
}