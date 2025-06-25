package BOJ_28400

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val st = StringTokenizer(nextLine())
    val array = Array(5) { _ -> st.nextToken().toInt() }

    println(array[0] * array[1] - array[2] * array[3] * array[4])
}
