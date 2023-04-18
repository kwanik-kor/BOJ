package knapsack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12920
 */
public class knapsack_12920_normalKnapsack2 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dp;
    static int K;

    public static void main(String[] args) throws Exception {
        new knapsack_12920_normalKnapsack2().solve();
        bw.close();
    }

    private void solve() throws Exception {
        List<Knapsack> knapsacks = initializeAndReturnList();
        int totalCnt = knapsacks.size();
        for (int i = 1; i <= totalCnt; i++) {
            for (int j = K; j >= 1; j--) {
                if (j >= knapsacks.get(i - 1).weight) {
                    dp[j] = Math.max(dp[j], dp[j - knapsacks.get(i - 1).weight] + knapsacks.get(i - 1).happiness);
                }
            }
        }

        bw.write(dp[K] + "");
    }

    private List<Knapsack> initializeAndReturnList() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Knapsack> ret = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int happiness = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int bit = 0; count > 0; bit++) {
                int tempCount = Math.min(1 << bit, count);
                count -= tempCount;
                ret.add(new Knapsack(weight * tempCount, happiness * tempCount));
            }
        }
        br.close();

        dp = new int[K + 1];

        return ret;
    }

    private static class Knapsack {
        int weight, happiness;

        public Knapsack(int weight, int happiness) {
            this.weight = weight;
            this.happiness = happiness;
        }
    }
}
