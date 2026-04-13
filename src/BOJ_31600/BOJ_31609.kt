package BOJ_31600

fun main() {
    readln()
    readln().split(" ").map { it.toInt() }.toSet().toList().sorted().forEach { println(it) }
}
