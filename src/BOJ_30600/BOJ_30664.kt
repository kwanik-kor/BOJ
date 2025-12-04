package BOJ_30600

fun main() {
    while(true) {
        val n = readLine()!!.trim()
        if (n == "0") break

        if (isMultipleOf42(n)) {
            println("PREMIADO")
        } else {
            println("TENTE NOVAMENTE")
        }
    }
}

fun isMultipleOf42(s: String): Boolean {
    var mod = 0
    for (c in s) {
        mod = (mod * 10 + (c - '0')) % 42
    }
    return mod == 0
}