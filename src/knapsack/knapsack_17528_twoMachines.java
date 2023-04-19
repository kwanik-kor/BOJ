package knapsack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17528
 * 2. 풀이
 *  - A가 일하지 않은 동안 B가 일한 시간을 통해서 냅색화하여 풀기
 */
public class knapsack_17528_twoMachines {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        new knapsack_17528_twoMachines().solve();
        bw.close();
    }

    private void solve() throws Exception {
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[250 * 250 + 1];

        Arrays.fill(dp, 250 * 250 + 1);
        dp[0] = 0;

        int totalA = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            totalA += a;

            for (int t = 250 * 250; t >= a; t--) {
                dp[t] = Math.min(dp[t], dp[t - a] + b);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= totalA; i++) {
            ans = Math.min(ans, Math.max(totalA - i, dp[i]));
        }

        bw.write(ans + "");
    }

}
