package BOJ_14000

import kotlin.math.max

fun main() {
    val str = readLine() ?: return
    println(findLongestPalindromeLength(str))
}

fun findLongestPalindromeLength(str: String): Int =
    (str.indices).maxOf { i ->
        max(
            expandAroundCenter(str, i, i),
            expandAroundCenter(str, i, i + 1)
        )
    }

fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right

    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return r - l - 1
}
