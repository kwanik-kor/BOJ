package BOJ_32400

fun main() = println((0 until readln().toInt()).count { readln().toInt() % 2 == 1 })