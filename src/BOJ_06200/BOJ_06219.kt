package BOJ_06200

import kotlin.math.sqrt

fun main() {
    val (a, b, d) = readLine()!!.split(" ").map { it.toInt() }
    val eratos = BooleanArray(b + 1) { true }
    for (i in 2 .. sqrt(b.toDouble()).toInt()) {
        if (!eratos[i]) continue

        for (j in i + i .. b step i) {
            eratos[j] = false
        }
    }

    val ch = d.toString()
    val ans = (a .. b).filter { eratos[it] }.count {
        it.toString().contains(ch)
    }
    println(ans)
}