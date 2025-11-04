package BOJ_32300

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    val (af, bf) = (0 until n).fold(1 to 1) { (com, blame), _ ->
        val tempCom = com + a
        val tempBlam = blame + b
        when {
            tempCom == tempBlam -> tempCom to tempBlam - 1
            tempBlam > tempCom -> tempBlam to tempCom
            else -> tempCom to tempBlam
        }
    }

    println("$af $bf")
}