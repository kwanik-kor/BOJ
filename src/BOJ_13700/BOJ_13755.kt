package BOJ_13700

fun main() {
    val (w1, h1) = readLine()!!.split(" ").map { it.toInt() }
    val (w2, h2) = readLine()!!.split(" ").map { it.toInt() }
    val (w3, h3) = readLine()!!.split(" ").map { it.toInt() }

    val area = w1 * h1 + w2 * h2 + w3 * h3
    val side = kotlin.math.sqrt(area.toDouble()).toInt()

    if (side * side != area) {
        println(0)
        return
    }

    val rectangles = listOf(
        listOf(w1, h1),
        listOf(h1, w1),
        listOf(w2, h2),
        listOf(h2, w2),
        listOf(w3, h3),
        listOf(h3, w3)
    )

    for (i in 0..1) {
        for (j in 2..3) {
            for (k in 4..5) {
                val r1 = rectangles[i]
                val r2 = rectangles[j]
                val r3 = rectangles[k]

                if (canFormSquare(r1, r2, r3, side)) {
                    println(1)
                    return
                }
            }
        }
    }

    println(0)
}

fun canFormSquare(r1: List<Int>, r2: List<Int>, r3: List<Int>, side: Int): Boolean {
    val w1 = r1[0]; val h1 = r1[1]
    val w2 = r2[0]; val h2 = r2[1]
    val w3 = r3[0]; val h3 = r3[1]

    if (w1 == side) {
        if (w2 == side && w3 == side && h1 + h2 + h3 == side) return true
        if (w2 + w3 == side && h1 + h2 == side && h1 + h3 == side) return true
    }

    if (w2 == side) {
        if (w1 == side && w3 == side && h1 + h2 + h3 == side) return true
        if (w1 + w3 == side && h2 + h1 == side && h2 + h3 == side) return true
    }

    if (w3 == side) {
        if (w2 == side && w1 == side && h1 + h2 + h3 == side) return true
        if (w2 + w1 == side && h3 + h1 == side && h3 + h2 == side) return true
    }

    return false
}