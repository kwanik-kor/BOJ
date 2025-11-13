package BOJ_32600

fun main() {
    val jangki = doubleArrayOf(13.0, 7.0, 5.0, 3.0, 3.0, 2.0)
    val a = readln().split(" ").mapIndexed { idx, value -> value.toDouble() * jangki[idx] }.sum()
    val b = readln().split(" ").mapIndexed { idx, value -> value.toDouble() * jangki[idx] }.sum() + 1.5

    println(if(a > b) "cocjr0208" else "ekwoo")
}