package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/27219
 */
public class sml_27219_emptyIsland {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0, n = N / 5; i < n; i++) {
            bw.write("V");
        }

        for (int i = 0, n = N % 5; i < n; i++) {
            bw.write("I");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
