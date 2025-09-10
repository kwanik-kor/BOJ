package BOJ_07500

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val t = readLine()!!.toInt()
    repeat(t) { idx ->
        bw.write("Scenario #${idx + 1}\n")

        val s = readLine()!!.toInt()
        val nextMap = mutableMapOf<String, String>()
        val hasIncoming = mutableSetOf<String>()

        repeat(s - 1) {
            val (from, to) = readLine()!!.split(" ")
            nextMap[from] = to
            hasIncoming.add(to)
        }

        var start = nextMap.keys.firstOrNull { it !in hasIncoming }
        
        var current = start
        repeat(s) {
            if (current == null) return@repeat
            bw.write("$current\n")
            current = nextMap[current]
        }

        bw.write("\n")
    }
    
    bw.flush()
    bw.close()
}