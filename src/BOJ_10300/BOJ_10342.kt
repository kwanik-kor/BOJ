package BOJ_10300

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 북동남서
    val directions = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    val slashDirection = mapOf<Int, Int>(
        0 to 1,
        1 to 0,
        2 to 3,
        3 to 2
    )

    val backtickDirection = mapOf<Int, Int>(
        0 to 3,
        1 to 2,
        2 to 1,
        3 to 0
    )

    val index = AtomicInteger(1)
    while(true) {
        val (w, l) = br.readLine()!!.split(" ").map { it.toInt() }

        // 종료 조건
        if (w == 0 && l == 0) break

        // 입력, 시작 위치 판별
        val map = Array(l) { CharArray(w) }
        var (sy, sx) = 0 to 0

        for (i in 0 until l) {
            val input = br.readLine()!!
            for (j in 0 until w) {
                map[i][j] = input[j]
                if (map[i][j] == '*') {
                    sy = i
                    sx = j
                }
            }
        }

        val q = LinkedList<Location>()
        q.add(Location(sy, sx, findStartDirection(sy, sx, l)))
        while (q.isNotEmpty()) {
            val current = q.poll()
            if (map[current.y][current.x] != '*' && (current.y == 0 || current.y == l - 1 || current.x == 0 || current.x == w - 1)) {
                map[current.y][current.x] = '&'
                break
            }

            var ny: Int = current.y
            var nx: Int = current.x
            while (true) {
                ny += directions[current.dir].first
                nx += directions[current.dir].second

                if (map[ny][nx] == '.') continue

                if (ny == 0 || nx == 0 || ny == l - 1 || nx == w - 1) {
                    q.add(Location(ny, nx, current.dir))
                    break
                }

                if (map[ny][nx] == '\\') {
                    q.add(Location(ny, nx, backtickDirection[current.dir]!!))
                    break
                } else if (map[ny][nx] == '/') {
                    q.add(Location(ny, nx, slashDirection[current.dir]!!))
                    break
                }
            }
        }

        // 출력
        bw.write("HOUSE ${index.getAndIncrement()}\n")
        for (i in 0 until l) {
            bw.write("${map[i].joinToString("")}\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

fun findStartDirection(y: Int, x: Int, l: Int): Int =
    when {
        y == 0 -> 2
        x == 0 -> 1
        y == l - 1 -> 0
        else -> 3
    }

data class Location(val y: Int, val x: Int, val dir: Int)