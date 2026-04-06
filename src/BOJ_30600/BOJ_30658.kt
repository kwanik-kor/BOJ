package BOJ_30600

fun main() {
    val sb = StringBuilder()
    generateSequence { readln().toInt().takeIf { it != 0 } }
        .forEach { n ->
            List(n) { readln().toInt() }
                .reversed()
                .forEach { sb.appendLine(it) }
            sb.appendLine(0)
        }
    print(sb)
}
