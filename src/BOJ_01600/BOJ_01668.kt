package BOJ_01600

fun main() {
    val n = readln().toInt()

    val trophies = (0 until n).map{ readln().toInt() }

    val left = trophies.fold(0 to 0) { (count, max), trophy ->
        if (trophy > max) (count + 1) to trophy else count to max
    }.first
    val right = trophies.asReversed().fold(0 to 0) { (count, max), trophy ->
        if (trophy > max) (count + 1) to trophy else count to max
    }.first
    println("$left\n$right")
}