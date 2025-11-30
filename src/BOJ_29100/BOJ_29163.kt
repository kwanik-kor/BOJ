package BOJ_29100

fun main() {
    val n = readln().toInt()
    val (even, odd) = readln().split(" ").fold(0 to 0) {(e, o), v ->
        if (v.toInt() % 2 == 0) e + 1 to o else e to o + 1
    }

    println(if (even > odd) "Happy" else "Sad")
}