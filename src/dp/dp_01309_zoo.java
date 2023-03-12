package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1309
 */
public class dp_01309_zoo {
    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 1];
        memo[0] = 1;
        memo[1] = 3;
        for (int i = 2; i <= N; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 2]) % MOD;
        }

        bw.write(memo[N] + "");
        bw.close();
        br.close();
    }
}
