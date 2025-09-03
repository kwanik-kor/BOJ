package BOJ_09900

fun main() {
    var index = 1
    while (true) {
        val first = readLine()!!
        val second = readLine()!!

        if (first == "END" && second == "END") {
            return
        }

        val firstChars = first.toCharArray().sorted()
        val secondChars = second.toCharArray().sorted()

        var result = true
        if (firstChars.size == secondChars.size) {
            for (i in firstChars.indices) {
                if (secondChars[i] != firstChars[i]) {
                    result = false
                    break
                }
            }
        } else {
            result = false
        }

        println("Case $index: ${if (result) "same" else "different" }")
        index++
    }
}