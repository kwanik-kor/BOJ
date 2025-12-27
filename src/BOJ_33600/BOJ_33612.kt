package BOJ_33600

fun main() {
    val dates = listOf(
        2024 to 8,
        2025 to 3,
        2025 to 10,
        2026 to 5,
        2026 to 12
    )
    val n = readln().toInt()

    println("${dates[n - 1].first} ${dates[n - 1].second}")
}