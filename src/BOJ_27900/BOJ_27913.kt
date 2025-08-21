package BOJ_27900

fun main() {
    val str = "SciComLove"
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }

    var upperCount = 0
    var target = (0 until n)
        .map { idx -> str[idx % 10] }
        .onEach { if (it.isUpperCase()) upperCount++ }
        .toMutableList()

    repeat(q) {
        val idx = readLine()!!.toInt() - 1
        val ch = target[idx]
        if (ch.isUpperCase()) {
            target[idx] = ch.lowercaseChar()
            upperCount--
        } else {
            target[idx] = ch.uppercaseChar()
            upperCount++
        }

        println(upperCount)
    }
}