package knapsack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1535
 */
public class knapsack_01535_hello {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[101];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer lst = new StringTokenizer(br.readLine());
        StringTokenizer hst = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(lst.nextToken());
            int h = Integer.parseInt(hst.nextToken());
            for (int j = 100; j > l; j--) {
                dp[j] = Math.max(dp[j], dp[j - l] + h);
            }
        }

        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            ans = Math.max(ans, dp[i]);
        }

        bw.write(ans + "");
        bw.close();
        br.close();
    }

}
