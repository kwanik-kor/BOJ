package BOJ_33900

fun skill(type: String, point: Pair<Int, Int>): Pair<Int, Int> {
    return when (type) {
        "A" ->
            when (point) {
                0 to 0 -> 2 to 0
                0 to 1 -> 2 to 1
                1 to 0 -> 3 to 0
                1 to 1 -> 3 to 1
                2 to 0 -> 0 to 0
                2 to 1 -> 0 to 1
                3 to 0 -> 1 to 0
                else -> 1 to 1
            }
        "B" ->
            when (point) {
                0 to 0 -> 1 to 1
                0 to 1 -> 1 to 0
                1 to 0 -> 0 to 1
                1 to 1 -> 0 to 0
                2 to 0 -> 3 to 1
                2 to 1 -> 3 to 0
                3 to 0 -> 2 to 1
                else -> 2 to 0
            }
        "C" ->
            when (point) {
                0 to 0 -> 3 to 1
                0 to 1 -> 3 to 0
                1 to 0 -> 2 to 1
                1 to 1 -> 2 to 0
                2 to 0 -> 1 to 1
                2 to 1 -> 1 to 0
                3 to 0 -> 0 to 1
                else -> 0 to 0
            }
        else ->
            when (point) {
                0 to 0 -> 0 to 1
                0 to 1 -> 1 to 1
                1 to 0 -> 0 to 0
                1 to 1 -> 2 to 1
                2 to 0 -> 1 to 0
                2 to 1 -> 3 to 1
                3 to 0 -> 2 to 0
                else -> 3 to 0
            }
    }
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() - 1 }
    val k = readln().toInt()

    val finalPosition = readln()
        .asSequence()
        .fold(n to m) { currentPosition, spell ->
            skill(spell.toString(), currentPosition)
        }

    println("${finalPosition.first + 1} ${finalPosition.second + 1}")
}