package BOJ_31400

fun main() {
    val n = readLine()!!.toInt()
    val friends = readLine()!!.split(" ")
    val elice = readLine()!!
    println(friends.count { it == elice })
}