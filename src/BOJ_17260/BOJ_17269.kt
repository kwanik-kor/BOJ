package BOJ_17260

val strokes = mapOf<Char, Int>('A' to 3, 'B' to 2, 'C' to 1, 'D' to 2, 'E' to 4, 'F' to 3, 'G' to 1, 'H' to 3, 'I' to 1, 'J' to 1, 'K' to 3, 'L' to 1, 'M' to 3, 'N' to 2, 'O' to 1, 'P' to 2, 'Q' to 2, 'R' to 2, 'S' to 1, 'T' to 2, 'U' to 1, 'V' to 1, 'W' to 1, 'X' to 2, 'Y' to 2, 'Z' to 1,)

fun toStrokes(name: String): List<Int> {
    return name.toCharArray().map { strokes.getValue(it) }
}

fun concatenate(lengths: List<Int>, names: List<List<Int>>): List<Int> {
    val ret = arrayListOf<Int>()
    val min = lengths.min()
    for (i in 0 until min) {
        ret.add(names[0][i])
        ret.add(names[1][i])
    }

    if (names[0].size > min) {
        (min..names[0].size - 1).forEach { ret.add(names[0][it]) }
    }

    if (names[1].size > min) {
        (min..names[1].size - 1).forEach { ret.add(names[1][it]) }
    }
    return ret
}

fun compatibility(nums: List<Int>): List<Int> {
    if (nums.size == 2) {
        return nums
    }
    return compatibility(nums.zipWithNext { a, b -> (a + b) % 10 })
}

fun main() {
    val lengths = readLine()!!.split(" ").map { it.toInt() }
    val names = readLine()!!.split(" ").map { toStrokes(it) }

    val result = compatibility(concatenate(lengths, names))
    val percent = result[0] * 10 + result[1]

    println("$percent%")
}