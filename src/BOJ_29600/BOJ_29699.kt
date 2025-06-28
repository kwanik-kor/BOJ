package BOJ_29600

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val label = "WelcomeToSMUPC"
    println(label[(nextInt() - 1) % 14])
}