package BOJ_21100

fun multiply(matrix: List<List<Int>>, other: Array<Int>): Array<Int> =
    matrix.map { row ->
        row.withIndex().fold(0) { acc, (j, value) ->
            (acc + (value * other[j]) % 37) % 37
        }
    }.toTypedArray()

fun convertCharToInt(char: Char): Int =
    when (char) {
        in 'A'..'Z' -> char - 'A'
        in '0'..'9' -> char - '0' + 26
        else -> 36
    }

fun convertIntToChar(num: Int): Char =
    when (num) {
        in 0..25 -> ('A' + num)
        in 26..35 -> ('0' + (num - 26)).toChar()
        else -> ' '
    }

fun main() {
    val n = readLine()!!.toInt()
    val matrix = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    var input = readLine()!!
    if (input.length % n != 0) {
        input = input.padEnd((input.length + n - 1) / n * n, ' ')
    }

    val result = input
        .map { it -> convertCharToInt(it) }
        .chunked(n).joinToString(separator = "") { chunk ->
            multiply(matrix, chunk.toTypedArray())
                .map { convertIntToChar(it) }
                .joinToString(separator = "")
        }

    println(result)
}