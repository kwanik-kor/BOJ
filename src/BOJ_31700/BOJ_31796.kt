package BOJ_31700

fun main() {
    val n = readln().toInt()
    val books = readln().split(" ").map { it.toInt() }.sorted()

    val (cnt, _) = books.fold(0 to 0) { (count, price), book ->
        if (price * 2 <= book) count + 1 to book else count to price
    }
    println(cnt)
}