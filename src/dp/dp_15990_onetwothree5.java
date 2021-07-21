package dp;

import java.io.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15990
 * 2. 풀이
 *  - 세 가지 수(1, 2, 3)을 이용해서 특정한 수를 만들어야 하는데, 두 수가 연속적으로 나타나서는 안된다.
 *    > 마지막 수가 1이라면 앞에 2나 3이 올 수 있다는 것이고, 2나 3일 경우에도 마찬가지로 해당 수를 제외하고 올 수 있다.
 *     >> 여기에 착안해서 점화식을 만들어 낼 수 있음
 */
public class dp_15990_onetwothree5 {

    static final int MOD = 1000000009;

    static long[][] dp;

    static void calcDp() {
        dp = new long[100001][4];
        dp[1][1] = dp[2][2] = dp[3][3] = 1L;
        dp[3][1] = dp[3][2] = 1L;

        for(int i = 4; i < dp.length; i++) {
            dp[i][1] = (dp[i - 1][2] % MOD + dp[i - 1][3] + MOD) % MOD;
            dp[i][2] = (dp[i - 2][1] % MOD + dp[i - 2][3] + MOD) % MOD;
            dp[i][3] = (dp[i - 3][1] % MOD + dp[i - 3][2] + MOD) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        calcDp();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long ans = (dp[n][1] % MOD + dp[n][2] % MOD + dp[n][3] % MOD) % MOD;
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
