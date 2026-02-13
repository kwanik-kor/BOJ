package BOJ_34700

fun main() {
    val cnt = (0 until readln().toInt()).count {
        val input = readln().split(" ").map { it.toInt() }
        input[0] >= 1000
                || input[1] >= 1600
                || input[2] >= 1500
                || (input[3] < 30 && input[3] != -1)
    }
    println(cnt)
}