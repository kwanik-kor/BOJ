package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2721
 * 2. 풀이
 *  - DP 이용
 */
public class math_02721_triangularNumber {

    static int[] input;
    static int[] dp, t;
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        input = new int[T];
        for(int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[i]);
        }

        dp = new int[max + 1];
        t = new int[max + 2];
        for(int i = 1; i < t.length; i++) {
            t[i] = t[i - 1] + i;
        }

        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + i * t[i + 1];
        }

        for(int i = 0; i < T; i++) {
            bw.write(dp[input[i]] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
