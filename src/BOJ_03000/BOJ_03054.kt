package BOJ_03000

/**
 * ..#..
 * .#.#.
 * #.A.#
 * .#.#.
 * ..#..
 */
fun main() {
    val last = "..#.."
    val frame = listOf(
        "..#.",
        ".#.#",
        "#.?.",
        ".#.#",
        "..#.",
    )

    val input = readln()
    for (i in 0 until 5) {
        for (size in 0 until input.length) {
            if (size % 3 == 2 || (i == 2 && (size - 1) % 3 == 2)) {
                print(frame[i].replace('?', input[size]).replace('#', '*'))
            } else {
                print(frame[i].replace('?', input[size]))
            }
        }
        if (input.length % 3 == 0 && last[i] == '#') {
            print('*')
        } else {
            print(last[i])
        }

        println()
    }

}