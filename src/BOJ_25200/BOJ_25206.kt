package BOJ_25200

fun main() {
    val grades = mapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0
    )

    val (credit, total) = (0 until 20).fold(0.0 to 0.0) { (c, t), _ ->
        val inputs = readln().split(" ")
        if (inputs[2] == "P") {
            c to t
        } else {
            (c + inputs[1].toDouble()) to (t + grades[inputs[2]]!!.toDouble() * inputs[1].toDouble())
        }
    }
    println(String.format("%.5f", total / credit))
}