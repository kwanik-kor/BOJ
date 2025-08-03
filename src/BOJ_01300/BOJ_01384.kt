package BOJ_01300

data class Child(val name: String, val negatives: List<Int>) {
    val hasNegative: Boolean get() = negatives.isNotEmpty()
}

fun solve(groupNo: Int, n: Int) {
    println("Group $groupNo")

    val children = List(n) { i ->
        val tokens = readLine()!!.split(" ")
        val name = tokens.first()
        val negatives = tokens.drop(1)
            .mapIndexedNotNull { idx, s -> if (s == "N") (i + n - 1 - idx) % n else null }
        Child(name, negatives)
    }

    if (children.none { it.hasNegative }) {
        println("Nobody was nasty")
    } else {
        children
            .flatMap { child -> child.negatives.map { it to child.name } }
            .forEach { (idx, childName) ->
                println("${children[idx].name} was nasty about $childName")
            }
    }
    println()
}

fun main() {
    generateSequence { readLine()!!.toInt() }
        .takeWhile { it != 0 }
        .withIndex()
        .forEach { (idx, n) -> solve(idx + 1, n) }
}
