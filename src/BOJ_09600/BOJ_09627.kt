package BOJ_09600

fun main() {
    val n = readln().toInt()
    val inputs = (0 until n).map { readln() }.toMutableList()

    val (totalLength, dollarIndex) = inputs.foldIndexed(0 to -1) { index, (length, dollarIdx), str ->
        if (str == "$") {
            length to index
        } else {
            (length + str.length) to dollarIdx
        }
    }

    fun numberToText(num: Int): String {
        val ones = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val teens = arrayOf("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                           "sixteen", "seventeen", "eighteen", "nineteen")
        val tens = arrayOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

        val result = StringBuilder()

        // 백의 자리
        if (num >= 100) {
            result.append(ones[num / 100])
            result.append("hundred")
        }

        val remainder = num % 100

        // 십의 자리와 일의 자리
        when {
            remainder >= 20 -> {
                result.append(tens[remainder / 10])
                if (remainder % 10 != 0) {
                    result.append(ones[remainder % 10])
                }
            }
            remainder >= 10 -> {
                result.append(teens[remainder - 10])
            }
            remainder > 0 -> {
                result.append(ones[remainder])
            }
        }

        return result.toString()
    }

    for (i in totalLength + 1 .. 999) {
        val eng = numberToText(i)
        if (totalLength + eng.length == i) {
            inputs[dollarIndex] = eng
            println(inputs.joinToString(" "))
            break
        }
    }
}