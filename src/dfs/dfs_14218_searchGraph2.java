package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14218
 * 2. 풀이
 *  - BFS로 풀어벌임 (출발 노드를 수도로 잡고, 각 노드에 대한 최단 거리를 계산하면 됨)
 *   > Query에 대한 효율 개선 방안 및 DFS로 재풀이 해볼 것
 */
public class dfs_14218_searchGraph2 {

    static final int INF = 987654321;

    static int N, M;
    static int[] dist;
    static Map<Integer, Set<Integer>> edges;

    static void setDist() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : edges.get(now)) {
                if(dist[next] != INF) continue;
                dist[next] = dist[now] + 1;
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

        edges = new HashMap<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getNode(a).add(b);
            getNode(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getNode(a).add(b);
            getNode(b).add(a);

            dist = new int[N + 1];
            Arrays.fill(dist, INF);

            setDist();

            for(int n = 1; n <= N; n++) {
                bw.write(dist[n] == INF? "-1 " : (dist[n] + " "));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static Set<Integer> getNode(int n) {
        return edges.computeIfAbsent(n, k -> new HashSet<>());
    }
}
