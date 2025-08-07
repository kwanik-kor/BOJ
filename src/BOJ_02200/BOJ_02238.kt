package BOJ_02200

fun main() {
    val (u, n) = readLine()!!.split(" ").map { it.toInt() }
    val bidders = List(n) { i ->
        val input = readLine()!!.split(" ")
        Bidder(i, input[0], input[1].toInt())
    }

    bidders.groupBy { it.price }
        .let { grouped ->
            val minCount = grouped.values.minOf { it.size }
            grouped.filterValues { it.size == minCount }
                .minByOrNull { it.key }!!
                .value
                .minByOrNull { it.idx }!!
        }
        .let { println("${it.name} ${it.price}") }
}

data class Bidder(
    val idx: Int,
    val name: String,
    val price: Int
)