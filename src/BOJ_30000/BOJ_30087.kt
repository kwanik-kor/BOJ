package BOJ_30000

import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val seminarRooms = mapOf(
        "Algorithm" to "204",
        "DataAnalysis" to "207",
        "ArtificialIntelligence" to "302",
        "CyberSecurity" to "B101",
        "Network" to "303",
        "Startup" to "501",
        "TestStrategy" to "105"
    )

    val N = nextLine().toInt()
    for (i in 1..N) {
        println(seminarRooms[nextLine()])
    }
}