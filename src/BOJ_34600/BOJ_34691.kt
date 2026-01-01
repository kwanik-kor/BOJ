package BOJ_34600

fun main() {
    while (true) {
        val line = readln()
        if (line == "end") break
        when (line) {
            "animal" -> println("Panthera tigris")
            "flower" -> println("Forsythia koreana")
            "tree" -> println("Pinus densiflora")
            else -> return
        }
    }
}