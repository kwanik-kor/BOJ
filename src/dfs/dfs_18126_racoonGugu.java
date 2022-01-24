package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18126
 * 2. 풀이
 *  - DFS로 방문한 노드의 거리를 계속해서 갱신해주면 되는 문제
 */
public class dfs_18126_racoonGugu {

    static int N;
    static long[] dist;
    static boolean[] visit;
    static List<Node>[] adj;

    static void dfs(int idx) {
        visit[idx] = true;
        for(Node next : adj[idx]) {
            if(visit[next.n]) continue;
            dist[next.n] = dist[idx] + next.dist;
            dfs(next.n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        adj = new List[N];
        dist = new long[N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long dist = Long.parseLong(st.nextToken());
            adj[a].add(new Node(b, dist));
            adj[b].add(new Node(a, dist));
        }

        dfs(0);

        long ans = 0L;
        for(int i = 1; i < N; i++) {
            ans = Math.max(ans, dist[i]);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int n;
        long dist;
        public Node(int n, long dist) {
            this.n = n;
            this.dist = dist;
        }
    }
}
