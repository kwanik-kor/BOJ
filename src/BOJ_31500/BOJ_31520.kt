package BOJ_31500

fun main() {
    val target = readln()
    val sb = StringBuilder()

    for (k in 1..1_000_000) {
        sb.append(k)
        val current = sb.toString()

        if (current == target) {
            println(k)
            return
        }
        if (current.length >= target.length) break
    }

    println(-1)
}
