package BOJ_01400

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()  // x축 길이 (0..N-1)
    val m = st.nextToken().toInt()  // y축 길이 (0..M-1)

    var left = 0
    var right = n - 1
    var bottom = 0
    var top = m - 1

    var x = 0
    var y = 0

    while (true) {
        // 동쪽: bottom 행을 오른쪽 끝까지
        x = right; y = bottom
        bottom++
        if (bottom > top) { println("$x $y"); return }

        // 북쪽: right 열을 위쪽 끝까지
        y = top; x = right
        right--
        if (left > right) { println("$x $y"); return }

        // 서쪽: top 행을 왼쪽 끝까지
        x = left; y = top
        top--
        if (bottom > top) { println("$x $y"); return }

        // 남쪽: left 열을 아래쪽 끝까지
        y = bottom; x = left
        left++
        if (left > right) { println("$x $y"); return }
    }
}