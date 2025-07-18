package BOJ_21000

import java.util.PriorityQueue

fun solve(coins: List<Coin>) {
    val q = PriorityQueue<Coin>(coins)

    fun notEmptyThenAdd(coin: Coin) = coin.decrement().takeIf { it.hasMore() }?.let { q.add(it) }

    val result = buildString {
        while (q.size > 1) {
            val a = q.poll()
            val b = q.poll()

            appendLine("${a.index} ${b.index}")

            notEmptyThenAdd(a)
            notEmptyThenAdd(b)
        }
    }

    if (q.isEmpty()) {
        println("yes\n$result")
    } else {
        println("no")
    }
}

fun main() {
    readLine()
    val stacks = readLine()!!
        .split(" ")
        .mapIndexed { idx, value -> Coin(idx + 1, value.toInt()) }
        .filter { coin -> coin.hasMore() }

    if (stacks.isNotEmpty() && (stacks.sumOf { it.count } % 2 != 0 || stacks.maxOf { it.count } > stacks.sumOf { it.count } / 2)) {
        println("no")
        return
    }

    solve(stacks)
}

data class Coin(
    val index:Int,
    val count:Int
): Comparable<Coin> {

    fun decrement(): Coin = Coin(index, count - 1)

    fun hasMore(): Boolean = count > 0

    override fun compareTo(other: Coin): Int {
        return other.count.compareTo(count)
    }

}