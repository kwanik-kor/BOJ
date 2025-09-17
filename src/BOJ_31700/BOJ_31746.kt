package BOJ_31700

import java.math.BigInteger

fun main() {
    val n = BigInteger(readLine()!!)
    println(if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) "SciComLove" else "evoLmoCicS")
}