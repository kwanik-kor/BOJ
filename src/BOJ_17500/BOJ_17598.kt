package BOJ_17500

fun main() {
    var (tiger, lion) = (0 to 0)
    repeat(9) {
        if (readLine()!! =="Tiger") {
            tiger++
        } else {
            lion++
        }
    }
    println(if (tiger > lion) "Tiger" else "Lion")
}