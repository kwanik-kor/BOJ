package BOJ_28200

import java.util.Scanner

val direction = arrayOf("N", "E", "S", "W")

fun turnRight(index: Int): Int = (index + 1) % 4
fun turnBack(index: Int): Int = (index + 2) % 4
fun turnLeft(index: Int): Int = (index + 3) % 4

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val functions = arrayOf(::turnRight, ::turnBack, ::turnLeft)
    var dir = 0

    repeat(10) {
        val input = nextLine().toInt() - 1;
        dir = functions[input](dir)
    }

    println(direction[dir])
}
