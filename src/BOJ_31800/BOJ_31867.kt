package BOJ_31800

fun main() {
    val n = readln().toInt()
    val input = readln()
    val (even, odd) = input.fold(0 to 0) { (e, o), char ->
        if (char.digitToInt() % 2 == 0) (e + 1) to o else e to (o + 1)
    }

    println(
        when {
            even > odd -> 0
            odd > even -> 1
            else -> -1
        }
    )
}