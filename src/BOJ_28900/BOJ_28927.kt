package BOJ_28900

fun main() {
    val minutes = arrayOf(3, 20, 120)
    val max = readln().split(" ").mapIndexed { index, s -> s.toInt() * minutes[index] }.sum()
    val mel = readln().split(" ").mapIndexed { index, s -> s.toInt() * minutes[index] }.sum()
    println(if (max == mel) "Draw" else if (max > mel) "Max" else "Mel")
}