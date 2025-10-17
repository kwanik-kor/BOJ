package BOJ_07600

fun main() {
    while (true) {
        val (m, g, z, s, e) = readln().split(" ").map { it.toInt() }

        if (m == 0 && g == 0 && z == 0 && s == 0 && e == 0) break

        var maxStrength = 0

        // Zealot: 100 minerals, 0 gas, z strength
        // Stalker: 125 minerals, 50 gas, s strength
        // Sentry: 50 minerals, 100 gas, e strength

        // Maximum possible units based on constraints
        val maxZealots = m / 100
        val maxStalkers = minOf(m / 125, g / 50)
        val maxSentries = minOf(m / 50, g / 100)

        // Try all combinations of zealots, stalkers, and sentries
        for (zealots in 0..maxZealots) {
            for (stalkers in 0..maxStalkers) {
                for (sentries in 0..maxSentries) {
                    val mineralsUsed = zealots * 100 + stalkers * 125 + sentries * 50
                    val gasUsed = stalkers * 50 + sentries * 100

                    if (mineralsUsed <= m && gasUsed <= g) {
                        val strength = zealots * z + stalkers * s + sentries * e
                        maxStrength = maxOf(maxStrength, strength)
                    }
                }
            }
        }

        println(maxStrength)
    }
}