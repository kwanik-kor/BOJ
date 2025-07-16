package BOJ_31700

fun main() {
    val set = HashSet<Char>()
    val target = setOf('l', 'k', 'p')

    repeat(3) {
        val first = readLine()!![0]
        if (target.contains(first)) {
            set.add(first)
        } else {
            println("PONIX")
            return
        }
    }

    if (set == target) println("GLOBAL")
    else println("PONIX")
}