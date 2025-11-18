package BOJ_26500

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val sentence = readln()
        println(if (sentence.endsWith('.')) sentence else "$sentence.")
    }
}