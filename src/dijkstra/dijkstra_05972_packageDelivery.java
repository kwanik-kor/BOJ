package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5972
 */
public class dijkstra_05972_packageDelivery {
    static int N, M;
    static int[] dist;
    static Map<Integer, List<Node>> adj = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.computeIfAbsent(a, (t) -> new ArrayList<Node>()).add(new Node(b, c));
            adj.computeIfAbsent(b, (t) -> new ArrayList<Node>()).add(new Node(a, c));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(1);

        bw.write(dist[N] + "");
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int distance = now.dist;

            if (dist[now.pos] < distance) continue;
            for (Node next : adj.getOrDefault(now.pos, new ArrayList<>())) {
                int nextDist = distance + next.dist;
                if (nextDist < dist[next.pos]) {
                    dist[next.pos] = nextDist;
                    pq.add(new Node(next.pos, nextDist));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int pos;
        int dist;

        public Node(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
