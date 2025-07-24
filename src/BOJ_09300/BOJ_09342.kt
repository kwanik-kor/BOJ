package BOJ_09300

fun main() {
    val regex = "^[A-F]?A+F+C+[A-F]?\$"

    repeat(readLine()!!.toInt()) {
        val chromosome = readLine()!!

        if (chromosome.matches(regex.toRegex())) println("Infected!")
        else println("Good")
    }
}