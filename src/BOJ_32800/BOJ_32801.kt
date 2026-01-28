package BOJ_32800

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }

    val (f, bi, fb) = (1..n).fold(Triple(0, 0, 0)) { (f, bi, fb), i ->
        when {
            i % a == 0 && i % b == 0 -> Triple(f, bi, fb + 1)
            i % a == 0 -> Triple(f + 1, bi, fb)
            i % b == 0 -> Triple(f, bi + 1, fb)
            else -> Triple(f, bi, fb)
        }
    }

    println("$f $bi $fb")
}