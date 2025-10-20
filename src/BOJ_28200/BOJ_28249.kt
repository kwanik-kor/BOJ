package BOJ_28200

fun main() {
    val map = mapOf(
        "Poblano" to 1500,
        "Mirasol" to 6000,
        "Serrano" to 15500,
        "Cayenne" to 40000,
        "Thai" to 75000,
        "Habanero" to 125000
    )

    val n = readln().toInt()

    println(
        (0 until n).sumOf { map[readln()]!! }
    )
}