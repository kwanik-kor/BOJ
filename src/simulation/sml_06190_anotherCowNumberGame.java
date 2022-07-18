package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6190
 */
public class sml_06190_anotherCowNumberGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        int score = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N *= 3;
                N++;
            }
            score++;
        }
        bw.write(score + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
