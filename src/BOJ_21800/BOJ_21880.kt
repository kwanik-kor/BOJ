package BOJ_21800

fun main() {
    val inputs = readLine()!!.split(" ").map { it.toInt() }
    val min = inputs.min()
    val max = inputs.max()

    (1..min).forEach { i -> if (inputs[0] > inputs[1]) println("0:$i") else println("$i:0") }
    (1..max).forEach { j -> if (inputs[0] > inputs[1]) println("$j:$min") else println("$min:$j")}
}