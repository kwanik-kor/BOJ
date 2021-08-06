package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/8452
 * 2. 풀이
 *  1) 처음에는 단순하게 경로를 지워가며 BFS를 순회했으나 당연하게도 시간초과
 *  2) 이 문제의 핵심은 오프라인 쿼리(Offline Query) 였다.
 *    - 즉 쿼리를 받는 순간 처리하는 것이 아니라 쿼리를 모아두었다가 추후에 임의의 순서로 진행하는 것을 의미한다.
 *    - 현재 문제에서는 역순으로 쿼리를 진행했을 때,
 *     간선을 지우는 대신 추가해가며 풀이를 하면 된다.
 *      >> 그 이유는!!!!
 *         간선이 추가되었을 때는 최단거리가 반드시 늘어나는 것이 아니기 때문이다!
 *  3) 해결책을 도움을 좀 받아서 풀었는데, 다시 한 번 풀어봐야겠당
 */
public class bfs_08452_graphAndQuery {

    static final int INF = 987654321;

    static int N, M, Q;
    static int[] dist;
    static boolean[] notUsed;
    static Edge[] edges, queries;
    static List<Integer> ans = new ArrayList<>();
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    static void bfs() {
        Arrays.fill(dist, INF);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Integer next : map.get(now)) {
                if(dist[now] + 1 < dist[next]) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }

    static void setEdgeOnGraph() {
        for(int i = 1; i <= M; i++) {
            if(notUsed[i]) continue;
            map.get(edges[i].s).add(edges[i].e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        dist = new int[N + 1];
        edges = new Edge[M + 1];
        notUsed = new boolean[M + 1];
        queries = new Edge[Q];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b);
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = (st.nextToken().equals("E"))? 0 : 1;
            int no = Integer.parseInt(st.nextToken());
            if(type == 1) {
                notUsed[no] = true;
            }
            queries[i] = new Edge(type, no);
        }

        setEdgeOnGraph();
        bfs();

        for(int i = Q - 1; i >= 0; i--) {
            // 지우는 쿼리 였으면 간선 추가해 주기
            if(queries[i].s == 1) {
                Edge edge = edges[queries[i].e];
                map.get(edge.s).add(edge.e);

                if(dist[edge.e] <= dist[edge.s] + 1) continue;

                bfs();
            } else {
                ans.add(dist[queries[i].e] == INF? -1 : dist[queries[i].e]);
            }
        }

        int size = ans.size();
        for(int i = ans.size() - 1; i >= 0; i--) {
            bw.write(ans.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Edge {
        int s;
        int e;
        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
