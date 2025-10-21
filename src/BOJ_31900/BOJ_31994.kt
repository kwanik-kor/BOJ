package BOJ_31900

fun main() {
    val lecture = (1..7)
        .map { readln().split(" ") }
        .maxByOrNull { it[1].toInt() }
        ?.get(0)

    println(lecture)
}