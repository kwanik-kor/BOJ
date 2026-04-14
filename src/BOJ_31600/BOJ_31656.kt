package BOJ_31600

fun main() {
    val s = readln()
    val result = StringBuilder()

    for (c in s) {
        if (result.isEmpty() || result.last() != c) {
            result.append(c)
        }
    }

    println(result)
}
