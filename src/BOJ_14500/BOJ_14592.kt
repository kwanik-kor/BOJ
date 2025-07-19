package BOJ_14500

fun main() {
    fun parseLineToParticipant(idx: Int): Participant {
        val line = readLine()!!.split(" ").map { it.toInt() }
        return Participant(idx, line[0], line[1], line[2])
    }

    val n = readLine()!!.toInt()
    val participants = (1..n).map { idx -> parseLineToParticipant(idx) }.sorted()

    println(participants[0].code)
}

data class Participant(
    val code: Int,
    val score: Int,
    val tryCount: Int,
    val uploadTime: Int,
): Comparable<Participant> {

    override fun compareTo(other: Participant): Int {
        if (other.score == this.score) {
            if (other.tryCount == this.tryCount) {
                return this.uploadTime.compareTo(other.uploadTime)
            }
            return this.tryCount.compareTo(other.tryCount)
        }
        return other.score.compareTo(this.score)
    }

}