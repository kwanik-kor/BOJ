package BOJ_28300

fun main() {
    val weekend = 7 * 24 * 60 * 60L
    val factorial = (10 .. readln().toInt()).fold(362880L) { prev, cur -> prev * cur }
    println(factorial / weekend)
}