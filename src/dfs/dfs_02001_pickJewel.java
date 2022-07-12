package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2001
 */
public class dfs_02001_pickJewel {

    static int N;
    static int ans = 0;
    static List<Node>[] adj;
    static int[] jewel;
    static boolean[][] visit;

    static void solve(int state, int current, int cnt) {
        visit[state][current] = true;
        if (current == 1) {
            ans = Math.max(ans, cnt);
        }
        for (Node next : adj[current]) {
            if (!visit[state][next.n] && next.weight >= cnt) {
                solve(state, next.n, cnt);
            }

            if (jewel[current] != -1) {
                if ((state & (1 << jewel[current])) != 0) continue;
                int nextState = state | (1 << jewel[current]);
                if (!visit[nextState][next.n] && next.weight >= cnt + 1) {
                    solve(nextState, next.n, cnt + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewel = new int[N + 1];
        Arrays.fill(jewel, -1);
        for (int i = 0; i < K; i++) {
            jewel[Integer.parseInt(br.readLine())] = i;
        }

        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        visit = new boolean[1 << 16][N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        adj[1].add(new Node(1, 100));

        solve(0, 1, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int n;
        int weight;

        public Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }
    }
}
