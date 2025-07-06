package BOJ_28200

import java.util.Scanner
import java.util.StringTokenizer
import kotlin.math.min

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var st = StringTokenizer(nextLine())
    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    st = StringTokenizer(nextLine())
    val arr = Array(n) { _ -> st.nextToken().toInt() }

    var min = Integer.MAX_VALUE;
    for (i in 1 until n) {
        min = min(arr[i] * x + arr[i - 1] * x, min)
    }

    println(min)
}