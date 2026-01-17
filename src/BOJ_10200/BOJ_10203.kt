package BOJ_10200

fun main() {
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    repeat(readln().toInt()) {
        val str = readln()
        val cnt = str.count { vowels.contains(it) }
        println("The number of vowels in $str is $cnt.")
    }
}