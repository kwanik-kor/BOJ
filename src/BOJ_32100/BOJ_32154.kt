package BOJ_32100

fun main() {
    val teams = listOf (
        11 to "A B C D E F G H J L M",
        9 to "A C E F G H I L M",
        9 to "A C E F G H I L M",
        9 to "A B C E F G H L M",
        8 to "A C E F G H L M",
        8 to "A C E F G H L M",
        8 to "A C E F G H L M",
        8 to "A C E F G H L M",
        8 to "A C E F G H L M",
        8 to "A B C F G H L M",
    )

    val n = readln().toInt()
    println("${teams[n - 1].first}\n${teams[n - 1].second}")
}