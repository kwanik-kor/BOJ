package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16204
 */
public class math_16204_selectCard {

    static int N, O, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        O = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = N - O;

        bw.write((Math.min(O, K) + Math.min(X, N - K)) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
