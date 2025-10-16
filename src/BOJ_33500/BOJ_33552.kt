package BOJ_33500

fun main() {
    val w = readln().toInt()
    val n = readln().toInt()

    val grades = (0 until n).map {
        readln().split(" ").let { it[0].toDouble() to it[1].toInt() }
    }

    // 기존 점수 중 5.8 미만이 있으면 IMPOSSIBLE
    if (grades.any { it.first < 5.8 }) {
        println("IMPOSSIBLE")
        return
    }

    // 점수를 10배 스케일링 (5.8-10.0 -> 58-100)
    val sumWeight = grades.sumOf { it.second } + w
    val sumGradeWeight = grades.sumOf { (it.first * 10).toInt() * it.second }

    // 정수 올림: (80 * sumWeight - sumGradeWeight + w - 1) / w
    val need = (80 * sumWeight - sumGradeWeight + w - 1) / w

    when {
        need > 100 -> println("IMPOSSIBLE")
        need < 58 -> println("5.8")
        else -> println("%.1f".format(need / 10.0))
    }
}