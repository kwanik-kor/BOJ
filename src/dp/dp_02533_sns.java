package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2533
 * 2. 풀이
 *  - 부모 노드가 얼리어답터가 아니라면 자식 노드는 모두 얼리어답터여야만 한다.
 *    > 해당 아이디어에서 출발!
 */
public class dp_02533_sns {

    static int N;
    static int[][] dp;
    static boolean[] visit;
    static List<Integer>[] edges;

    static void solve(int n) {
        visit[n] = true;
        dp[n][0] = 1;
        for(Integer child : edges[n]) {
            if(visit[child]) continue;
            solve(child);
            dp[n][1] += dp[child][0];
            dp[n][0] += Math.min(dp[child][0], dp[child][1]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        edges = new List[N + 1];
        for(int i = 1; i <= N; i++)
            edges[i] = new ArrayList<>();
        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        solve(1);

        bw.write(Math.min(dp[1][0], dp[1][1]) + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
