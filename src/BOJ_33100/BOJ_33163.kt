package BOJ_33100

fun main() {
    val n = readln().toInt()
    val s = readln()
    s.forEach {
        print(
            when (it) {
                'J' -> 'O'
                'O' -> 'I'
                else -> 'J'
            }
        )
    }
}
