package BOJ_06900

fun main() {
    fun arrival(num: Int): Int = when (num) {
        99 -> 77
        67 -> 86
        90 -> 48
        40 -> 64
        54 -> 19
        9 -> 34
        else -> num
    }

    var pos = 1

    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            println("You Quit!")
            return
        }

        pos = if (n + pos > 100) pos else arrival(n + pos)
        println("You are now on square $pos")

        if (pos == 100) {
            println("You Win!")
            return
        }
    }
}