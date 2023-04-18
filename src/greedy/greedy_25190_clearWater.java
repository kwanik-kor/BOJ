package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25190
 */
public class greedy_25190_clearWater {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, maxLength = 0;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        new greedy_25190_clearWater().solve();

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        Hiker[] hikers = initializeAndReturnSortedHikers();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (hikers[i].p <= j && j < hikers[i].p + hikers[i].c) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hikers[i].p] + 1);
                } else if (j < hikers[i].p) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int maxCnt = 0;
        int max = 0;
        for (int i = 0; i < maxLength; i++) {
            if (dp[N][i] > maxCnt) {
                maxCnt = dp[N][i];
                max = i;
            }
        }

        bw.write(maxCnt + " " + max);
    }

    private Hiker[] initializeAndReturnSortedHikers() throws Exception {
        N = Integer.parseInt(br.readLine());

        Hiker[] hikers = new Hiker[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            hikers[i] = new Hiker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            maxLength = Math.max(maxLength, hikers[i].p + hikers[i].c);
        }

        Arrays.sort(hikers, 1, N + 1);
        dp = new int[N + 1][maxLength];

        return hikers;
    }

    private static class Hiker implements Comparable<Hiker> {
        private int p, c;

        public Hiker(int p, int c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public int compareTo(Hiker o) {
            if (p + c == o.p + o.c) {
                return p - o.p;
            }
            return (p + c) - (o.p + o.c);
        }
    }
}
