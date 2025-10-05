package BOJ_29700

fun main() {
    val line = readLine()!!
    val name = "DKSH"
    val count = (0 .. line.length - 4).count {
        var flag = true
        for (i in 0 until 4) {
            if (line[it + i] != name[i]) flag = false
        }
        flag
    }
    println(count)
}