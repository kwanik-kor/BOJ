package BOJ_30000

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextLine().toInt()
    for (i in 0 until N) {
        val st = StringTokenizer(nextLine())
        val array = Array(3) { _ -> st.nextToken().toInt() }
        println(String.format("%d", array[0] * (array[2] - 1) + array[1]))
    }
}