package BOJ_30600

import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt();
    when {
        N < 425 -> println("Violet")
        N < 450 -> println("Indigo")
        N < 495 -> println("Blue")
        N < 570 -> println("Green")
        N < 590 -> println("Yellow")
        N < 620 -> println("Orange")
        N <= 780 -> println("Red")
    }
}