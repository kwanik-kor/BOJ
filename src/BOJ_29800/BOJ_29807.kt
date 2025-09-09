package BOJ_29800

fun main() {
    val t = readLine()!!.toInt()
    val scores = readLine()!!.split(" ").map { it.toInt() }
    
    val korean = if (scores.size > 0) scores[0] else 0
    val math = if (scores.size > 1) scores[1] else 0
    val english = if (scores.size > 2) scores[2] else 0
    val inquiry = if (scores.size > 3) scores[3] else 0
    val foreign = if (scores.size > 4) scores[4] else 0
    
    var result = 0
    
    if (korean > english) {
        result += (korean - english) * 508
    } else {
        result += (english - korean) * 108
    }
    
    if (math > inquiry) {
        result += (math - inquiry) * 212
    } else {
        result += (inquiry - math) * 305
    }
    
    if (t >= 5) {
        result += foreign * 707
    }
    
    result *= 4763
    
    println(result)
}