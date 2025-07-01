package BOJ_01400

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextLine().toInt()
    val K = nextLine().toInt()

    val sieve = Array(N + 1) { _ -> 0 }
    for (i in 2..N) {
        if (sieve[i] == 0) {
            for (j in i..N step i) {
                sieve[j] = i
            }
        }
    }

    var cnt = 0;
    for (i in 1..N) {
        if ((sieve[i] == 0 && i <= K) || sieve[i] != 0 && sieve[i] <= K) {
            cnt++
        }
    }

    println(cnt)
}