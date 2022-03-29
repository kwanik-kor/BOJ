package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24444
 * 2. 일반적인 BFS에 방문 순서를 붙여줌
 */
public class bfs_24444_algorithmClass1 {

    static int N, M, R;
    static int[] visit;
    static Map<Integer, List<Integer>> adj;

    static void solve() {
        int idx = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(R);
        visit[R] = idx;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : adj.get(now)) {
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
        adj = new HashMap<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.computeIfAbsent(a, e -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, e -> new ArrayList<>()).add(a);
        }

        for(int i = 1; i <= N; i++) {
            if(adj.containsKey(i))
                Collections.sort(adj.get(i));
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
