package BOJ_28600

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val map: Map<Char, String> = listOf("MatKor", "WiCys", "CyKor", "AlKor", "\$clear")
        .associateBy { it.first()}

    println(map[readln()[0]])
}