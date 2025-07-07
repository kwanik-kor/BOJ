package BOJ_28200

fun main(args: Array<String>) {
    when (readLine()) {
        "fdsajkl;", "jkl;fdsa" -> println("in-out")
        "asdf;lkj", ";lkjasdf" -> println("out-in")
        "asdfjkl;" -> println("stairs")
        ";lkjfdsa" -> println("reverse")
        else -> println("molu")
    }
}