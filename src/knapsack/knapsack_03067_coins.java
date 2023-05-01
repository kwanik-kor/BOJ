package knapsack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크
 *  - https://www.acmicpc.net/problem/3067
 *  - https://www.acmicpc.net/problem/9084
 */
public class knapsack_03067_coins {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, target;
    static int[] coins = new int[20];
    static int[] memo = new int[10001];

    public static void main(String[] args) throws Exception {
        knapsack_03067_coins main = new knapsack_03067_coins();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        for (int coin = 0; coin < N; coin++) {
            for (int money = coins[coin]; money <= target; money++) {
                memo[money] += memo[money - coins[coin]];
            }
        }

        bw.write(memo[target] + "\n");
    }

    private void initialize() throws Exception {
        N = Integer.parseInt(br.readLine());
        Arrays.fill(memo, 0);
        memo[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());
    }

}
