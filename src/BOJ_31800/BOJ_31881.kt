package BOJ_31800

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, q) = br.readLine()!!.split(' ').map { it.toInt() }
    val computers = BooleanArray(n) { false }
    var count = n

    repeat(q) {
        val st = StringTokenizer(br.readLine()!!)
        when(st.nextToken()!!.toInt()) {
            1 -> {
                val index = st.nextToken().toInt() - 1
                if (!computers[index]) {
                    computers[index] = true
                    count--
                }
            }
            2 -> {
                val index = st.nextToken().toInt() - 1
                if (computers[index]) {
                    computers[index] = false
                    count++
                }
            }
            3 -> bw.write("$count\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}