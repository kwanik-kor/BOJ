package BOJ_01900

fun main() {
    fun isFriend(x: CharArray, y: CharArray): Boolean {
        val xCharset = x.toSet()
        val yCharset = y.toSet()

        return xCharset == yCharset
    }

    fun isAlmostFriend(x: CharArray, y: CharArray): Boolean {
        for (i in 0 until x.size - 1) {
            if ('0' < x[i] && x[i + 1] < '9') {
                x[i]--
                x[i + 1]++

                if (isFriend(x, y) && x[0] != '0') return true

                x[i]++
                x[i + 1]--
            }

            if ('0' < x[i + 1] && x[i] < '9') {
                x[i + 1]--
                x[i]++

                if (isFriend(x, y)) return true

                x[i + 1]++
                x[i]--
            }
        }
        return false
    }

    fun solve() {
        val inputs = readLine()!!.split(" ")
        val x = inputs[0].toCharArray()
        val y = inputs[1].toCharArray()

        if (isFriend(x, y)) {
            println("friends")
            return
        }


        if (isAlmostFriend(x, y) || isAlmostFriend(y, x)) {
            println("almost friends")
            return
        }

        println("nothing")
    }

    repeat(3) { solve() }
}