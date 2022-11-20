package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17175
 */
public class dp_17175_fibonacciIsBoring {

    static final int MOD = 1000000007;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        if (N == 1 || N == 0) {
            bw.write("1");
        } else {
            memo[0] = memo[1] = 1;
            for (int i = 2; i <= N; i++) {
                memo[i] = (memo[i - 2] % MOD + memo[i - 1] % MOD + 1) % MOD;
            }
            bw.write(memo[N] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
