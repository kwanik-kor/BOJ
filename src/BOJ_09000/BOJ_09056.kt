package BOJ_09000

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (origin, target) = readln().split(" ")
        val uniqueCnt = target.toSet().size
        var flag = true
        for (i in 0 until origin.length) {
            if (!target.contains(origin[i])) {
                flag = false
                break
            }
        }
        println(if (flag && origin.length == uniqueCnt) "YES" else "NO")
    }
}