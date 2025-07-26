package BOJ_29700

fun main() {
    val arr = readLine()!!.split(" ").map { it.toInt() }
    when {
        arr[0] >= 1000 && (arr[1] >= 8000 || arr[2] >= 260) -> println("Very Good")
        arr[0] >= 1000 -> println("Good")
        else -> println("Bad")
    }
}