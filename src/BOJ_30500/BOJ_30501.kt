package BOJ_30500

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val name = readLine()!!
        if (name.contains("S")) {
            println(name)
            return@repeat
        }
    }
}