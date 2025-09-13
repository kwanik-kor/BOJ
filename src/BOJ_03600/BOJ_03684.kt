package BOJ_03600

fun main() {
    val t = readLine()!!.toInt()
    val sequence = IntArray(2 * t)
    
    for (i in 0 until t) {
        sequence[2 * i] = readLine()!!.toInt()
    }
    
    for (a in 0..10000) {
        for (b in 0..10000) {
            var valid = true
            
            for (i in 0 until t) {
                val evenIndex = 2 * i + 1
                sequence[evenIndex] = (a.toLong() * sequence[2 * i] + b).toInt() % 10001
                
                if (i < t - 1) {
                    val nextOddExpected = (a.toLong() * sequence[evenIndex] + b).toInt() % 10001
                    if (nextOddExpected != sequence[2 * (i + 1)]) {
                        valid = false
                        break
                    }
                }
            }
            
            if (valid) {
                for (i in 0 until t) {
                    println(sequence[2 * i + 1])
                }
                return
            }
        }
    }
}