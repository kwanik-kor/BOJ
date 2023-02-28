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
 * 1. 문제 링크: https://www.acmicpc.net/problem/14284
 */
public class dijkstra_14284_connectEdge2 {
    static int[] dist;
    static Map<Integer, List<Node>> adj = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.computeIfAbsent(a, (t) -> new ArrayList<>()).add(new Node(b, c));
            adj.computeIfAbsent(b, (t) -> new ArrayList<>()).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(dist[end] + "");
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.pos] < now.dist) continue;
            for (Node next : adj.getOrDefault(now.pos, new ArrayList<>())) {
                int distance = now.dist + next.dist;
                if (distance < dist[next.pos]) {
                    dist[next.pos] = distance;
                    pq.add(new Node(next.pos, distance));
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
