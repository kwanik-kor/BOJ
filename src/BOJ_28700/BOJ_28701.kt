package BOJ_28700

import java.util.Scanner
import java.util.stream.IntStream

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt().toInt();
    val sum = IntStream.rangeClosed(0, N).sum();

    println(String.format("%d\n%d\n%d", sum, sum * sum, sum * sum))
}