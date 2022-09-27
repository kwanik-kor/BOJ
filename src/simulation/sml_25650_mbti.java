package simulation;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 1. 문제링크: https://www.acmicpc.net/problem/25640
 */
public class sml_25650_mbti {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String mbti = sc.nextLine();
        int N = Integer.parseInt(sc.nextLine());
        int cnt = (int) IntStream.range(0, N)
                .filter((idx) -> mbti.equals(sc.nextLine()))
                .count();

        System.out.println(cnt);
    }
}
