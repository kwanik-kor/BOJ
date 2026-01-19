package BOJ_28600

fun main() = println((0 until readln().toInt()).minOf { readln().split(" ").sumOf { it.toInt() } })
