package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5719
 */
public class dijkstra_05719_almostShortestWay {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, S, D;
    static int[] dist;
    static boolean[][] visit;
    static List<Node>[] adj;
    static List<Integer>[] parent;

    public static void main(String[] args) throws Exception {
        dijkstra_05719_almostShortestWay main = new dijkstra_05719_almostShortestWay();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            main.solve();
        }

        bw.close();
        br.close();
    }

    private void solve() throws Exception {
        initialize();

        dijkstra(S);
        backtracking(S, D);
        dijkstra(S);

        if (dist[D] == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(dist[D] + "\n");
        }
    }

    private void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.n] < now.cost) {
                continue;
            }

            for (Node next : adj[now.n]) {
                if (visit[now.n][next.n] || dist[next.n] < dist[now.n] + next.cost) {
                    continue;
                }

                if (dist[next.n] == dist[now.n] + next.cost) {
                    parent[next.n].add(now.n);
                } else {
                    dist[next.n] = dist[now.n] + next.cost;
                    parent[next.n].clear();
                    parent[next.n].add(now.n);
                    pq.add(new Node(next.n, dist[next.n]));
                }
            }
        }
    }

    private void backtracking(int start, int node) {
        if (node == start) {
            return;
        }
        for (Integer parent : parent[node]) {
            if (!visit[parent][node]) {
                visit[parent][node] = true;
                backtracking(start, parent);
            }
        }
    }

    private void initialize() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[N];
        adj = new ArrayList[N];
        parent = new ArrayList[N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    static class Node implements Comparable<Node> {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
