package BOJ_34800

fun main() {
    (1..readln().toInt())
        .map { readln() }
        .let { it.indexOf("yonsei") < it.indexOf("korea") }
        .let { if (it) "Yonsei Won!" else "Yonsei Lost..." }
        .let(::println)
}
