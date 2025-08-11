package BOJ_02900

fun main() {
    val word = readLine()!!

    var newWords = mutableListOf<String>()

    (1 until word.length - 1).forEach { i ->
        (i + 1 until word.length).forEach { j ->
            newWords.add(word.substring(0, i).reversed() + word.substring(i, j).reversed() + word.substring(j).reversed())
        }
    }

    newWords.sort()
    println(newWords[0])
}