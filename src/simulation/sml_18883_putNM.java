package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/18883
 */
public class sml_18883_putNM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                bw.write((row * M + col + 1) + "");
                bw.write(col == M - 1 ? "\n" : " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
