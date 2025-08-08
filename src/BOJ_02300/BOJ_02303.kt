package BOJ_02300

fun main() {
    val n = readLine()!!.toInt()

    val winner = (0 until n)
        .mapIndexed { idx, _ ->
            val nums = readLine()!!.split(" ").map { it.toInt() }
            val maxLastDigit = (0 until 5)
                .flatMap { i -> (i + 1 until 5)
                    .flatMap { j -> (j + 1 until 5)
                        .map { k -> listOf(i, j, k) } } }
                .maxOf { (i, j, k) -> (nums[i] + nums[j] + nums[k]) % 10 }
            idx to maxLastDigit
        }
        .maxWith(compareBy({ it.second }, { it.first }))
        .first + 1

    println(winner)
}