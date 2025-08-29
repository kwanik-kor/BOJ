package BOJ_24700

fun main() {
    while (true) {
        val (sour, honey) = readLine()!!.split(' ').map { it.toInt() }
        if (sour == 0 && honey == 0) break
        when {
            sour + honey == 13 -> println("Never speak again.")
            sour > honey -> println("To the convention.")
            sour < honey -> println("Left beehind.")
            else -> println("Undecided.")
        }
    }
}