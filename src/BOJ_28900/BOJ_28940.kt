package BOJ_28900

fun main() {
    // 페이지 너비 높이
    val (w, h) = readln().split(" ").map { it.toInt() }
    // 글자수, 글자 너비, 높이
    val (n, a, b) = readln().split(" ").map { it.toInt() }
    // 한 페이지에 들어갈 수 있는 글자
    val page = (w / a) * (h / b)
    println(if (page == 0) -1 else (n + page - 1) / page)
}
