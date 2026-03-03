package BOJ_31300

fun main() {
    val vowel = setOf('a', 'e', 'i', 'o', 'u')
    val input = readln()
    println("${input.count { it in vowel }} ${input.count { it in (vowel + 'y') }}")
}
