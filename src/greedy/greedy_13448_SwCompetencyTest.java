package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/13448
 */
public class greedy_13448_SwCompetencyTest {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, T;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        new greedy_13448_SwCompetencyTest().solve();

        bw.close();
    }

    private void solve() throws Exception {
        Problem[] problems = initializeAndReturnSortedProblems();

        for (int i = 1; i <= N; i++) {
            for (int t = 1; t <= T; t++) {
                long score = 0;
                if (t - problems[i].r >= 0) {
                    score = dp[i - 1][t - problems[i].r] + problems[i].getScore(t);
                }
                dp[i][t] = Math.max(dp[i - 1][t], score);
            }
        }

        long maxScore = 0;
        for (int i = 1; i <= T; i++) {
            maxScore = Math.max(maxScore, dp[N][i]);
        }

        bw.write(maxScore + "");
    }

    private Problem[] initializeAndReturnSortedProblems() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][T + 1];

        StringTokenizer constant = new StringTokenizer(br.readLine());
        StringTokenizer time = new StringTokenizer(br.readLine());
        StringTokenizer duration = new StringTokenizer(br.readLine());
        br.close();

        Problem[] problems = new Problem[N + 1];
        for (int i = 1; i <= N; i++) {
            problems[i] = new Problem(
                    Integer.parseInt(constant.nextToken()),
                    Integer.parseInt(time.nextToken()),
                    Integer.parseInt(duration.nextToken())
            );
        }
        Arrays.sort(problems, 1, N + 1);
        return problems;
    }

    private static class Problem implements Comparable<Problem> {
        int m, p, r;

        public Problem(int m, int p, int r) {
            this.m = m;
            this.p = p;
            this.r = r;
        }

        public long getScore(int t) {
            return (long) m - (long) t * p;
        }

        @Override
        public int compareTo(Problem o) {
            return Double.compare(((double) o.p) / o.r, ((double) p) / r);
        }
    }

}
