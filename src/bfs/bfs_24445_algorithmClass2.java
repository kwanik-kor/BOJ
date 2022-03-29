package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24445
 * 2. 풀이
 *  - 일반 BFS에 가중치가 생긴 문제
 */
public class bfs_24445_algorithmClass2 {

    static int N, M, R;
    static int[] visit;
    static List<Integer>[] adj;

    static void solve() {
        int idx = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        visit[R] = idx;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            for(int next : adj[now]) {
                if(visit[next] != 0) continue;
                visit[next] = ++idx;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];
        adj = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1; i<= N; i++) {
            adj[i].sort(Comparator.reverseOrder());
        }

        solve();

        for(int i = 1; i <= N; i++) {
            bw.write(visit[i] + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
