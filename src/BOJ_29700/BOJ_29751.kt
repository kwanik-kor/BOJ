package BOJ_29700

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val st = StringTokenizer(nextLine())
    val array = Array(2) { _ -> st.nextToken().toFloat() }
    println(String.format("%.1f", array[0] * array[1] / 2))
}