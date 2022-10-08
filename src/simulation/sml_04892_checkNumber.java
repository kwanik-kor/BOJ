package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4892
 */
public class sml_04892_checkNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            N *= 3;
            bw.write(String.format("%d. %s ", count++, N % 2 == 0 ? "even" : "odd"));

            N = N % 2 == 0
                    ? N / 2
                    : (N + 1) / 2;
            N *= 3;
            bw.write(String.format("%d\n", N / 9));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
