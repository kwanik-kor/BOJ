package algospot.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Poly {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MOD = 10000000, MAX = 100;
    static final int[][] memo = new int[101][101];

    public static void main(String[] args) throws Exception {
        memoization();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = (ans + memo[n][i]) % MOD;
            }
            bw.write(ans + "\n");
        }

        bw.close();
        br.close();
    }

    private static void memoization() {
        for (int i = 0; i <= MAX; i++) {
            memo[i][i] = 1;
            for (int j = 1; j < i; j++) {
                for (int k = 1; k <= i - j; k++) {
                    memo[i][j] = (memo[i][j] + (k + j - 1) * memo[i - j][k]) % MOD;
                }
            }
        }
    }
}
