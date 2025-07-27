package BOJ_01000

fun main() {
    val size = readLine()!!.split(" ").map { it.toInt() }
    val a = (1..size[0]).map { readLine()!!.toCharArray().map { it - '0' }.toMutableList() }
    val b = (1..size[0]).map { readLine()!!.toCharArray().map { it - '0' }.toMutableList() }

    var cnt = 0;
    for (row in 0 until size[0] - 2) {
        for (col in 0 until size[1] - 2) {
            if (a[row][col] != b[row][col]) {
                for (tempRow in row..row + 2) {
                    for (tempCol in col..col + 2) {
                        a[tempRow][tempCol] = 1 - a[tempRow][tempCol]
                    }
                }
                cnt++
            }
        }
    }

    for (row in 0 until size[0]) {
        for (col in 0 until size[1]) {
            if (a[row][col] != b[row][col]) {
                println(-1)
                return
            }
        }
    }

    println(cnt)
}