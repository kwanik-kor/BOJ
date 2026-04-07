package BOJ_30800

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    val result = (1..n)
        .asSequence()
        .map {
            readLine().split(" ").let { (x, y) ->
                x.toInt() to y.toInt()
            }
        }
        .minByOrNull { it.second }!!

    println("${result.first} ${result.second}")
}
