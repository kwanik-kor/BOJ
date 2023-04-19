package knapsack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10982
 */
public class knapsack_10982_luckyCookie {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] dp = new int[1000 * 100 + 1];

    public static void main(String[] args) throws Exception {
        knapsack_10982_luckyCookie main = new knapsack_10982_luckyCookie();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            bw.write(main.solve() + "\n");
        }
        bw.close();
    }

    private int solve() throws Exception {
        initializeDp();
        N = Integer.parseInt(br.readLine());

        int totalA = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            totalA += a;
            for (int t = 100000; t >= a; t--) {
                dp[t] = Math.min(dp[t], dp[t - a] + b);
            }
        }

        int ret = 987654321;
        for (int i = 0; i <= totalA; i++) {
            ret = Math.min(ret, Math.max(totalA - i, dp[i]));
        }

        return ret;
    }

    private void initializeDp() {
        Arrays.fill(dp, 1000 * 100 + 1);
        dp[0] = 0;
    }

}
