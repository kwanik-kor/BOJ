package BOJ_33800

/**
 * c: i번째 과목을 수강하여 얻을 수 있는 학점
 * s: 매주 i번째 과목이 진행되는 강의 횟수
 * dij: 매주 i번째 과목의 j번째 강의가 열리는 요일
 * h: 매주 i번째 과목의 j번째 강의가 열리는 시각(h:00 - h:59)
 */
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val subjects = (0 until n).map { Subject.fromString(readLine()!!) }
    val timetable = BooleanArray(120) { false }

    var totalCredit = 0
    var ans = false

    fun backtracking(idx: Int) {
        if (totalCredit >= m) {
            ans = true
            return
        }

        for (i in idx until n) {
            if (!subjects[i].available(timetable)) continue

            totalCredit += subjects[i].credit
            subjects[i].times.forEach { timetable[it] = true }

            backtracking(i + 1)

            totalCredit -= subjects[i].credit
            subjects[i].times.forEach { timetable[it] = false }
        }
    }

    backtracking(0)

    println(if (ans) "YES" else "NO")
}


class Subject(
    val credit: Int,
    val cnt: Int,
    val times: List<Int>
) {

    fun available(timetable: BooleanArray): Boolean = times.all { !timetable[it] }

    companion object {
        fun fromString(input: String): Subject {
            val parts = input.split(" ")
            val credit = parts[0].toInt()
            val cnt = parts[1].toInt()
            val times = mutableListOf<Int>()
            
            for (i in 0 until cnt) {
                val dayStr = parts[2 + i * 2]
                val hour = parts[3 + i * 2].toInt()
                
                val dayValue = when (dayStr) {
                    "MON" -> 0
                    "TUE" -> 1
                    "WED" -> 2
                    "THU" -> 3
                    "FRI" -> 4
                    else -> 0
                }
                
                times.add(dayValue * 24 + hour)
            }
            
            return Subject(credit, cnt, times)
        }
    }
}