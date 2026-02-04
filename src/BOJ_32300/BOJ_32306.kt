package BOJ_32300

fun main() {
    fun score() = readln().split(" ").withIndex().sumOf { (i, s) -> s.toInt() * (i + 1) }
    println(when (score().compareTo(score())) {
        1 -> 1
        -1 -> 2
        else -> 0
    })
}