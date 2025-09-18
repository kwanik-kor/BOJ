package BOJ_11200

fun main() {
    while (true) {
        val name = readLine()!!
        if (name == "#") break
        val numeral = readLine()!!.toInt()
        val number = readLine()!!.toInt()
        println("$name, $number, ${number.toString(numeral).toUpperCase()}")
    }
}