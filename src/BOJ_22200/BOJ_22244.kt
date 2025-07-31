package BOJ_22200

fun correctMagicNumber(digit: Char) = digit in "169"

fun checksum(str: String): Boolean =
    str.dropLast(1).sumOf { it.digitToInt().let { d -> d * d } } % 7 == str.last().digitToInt()

fun isLeapYear(yearPart: Int): Boolean {
    val year = if (yearPart < 600) yearPart + 2000 else yearPart + 1000
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

fun correctDate(str: String): Boolean {
    val (day, month, yearPart) = listOf(
        str.substring(0, 2).toInt(),
        str.substring(2, 4).toInt(),
        str.substring(4, 7).toInt(),
    )

    val daysInMonth = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val maxDay = if (month == 2 && isLeapYear(yearPart)) 29 else daysInMonth.getOrNull(month - 1) ?: return false
    return month in 1..12 && day in 1..maxDay
}

fun main() = repeat(3) {
    val input = readLine()!!
    val isValid = correctDate(input) && correctMagicNumber(input[7]) && checksum(input)
    println(if (isValid) "1" else "0")
}