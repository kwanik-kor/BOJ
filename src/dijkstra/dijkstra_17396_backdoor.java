package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17396
 */
public class dijkstra_17396_backdoor {
    static long[] dist;
    static Map<Integer, List<Node>> adj = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new long[N];

        st = new StringTokenizer(br.readLine());

        Set<Integer> ward = new HashSet<>();
        for (int i = 0; i < N; i++) {
            dist[i] = Long.MAX_VALUE;
            if (Integer.parseInt(st.nextToken()) == 1 && i != N - 1) {
                ward.add(i);
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (ward.contains(a)|| ward.contains(b)) continue;

            adj.computeIfAbsent(a, (t) -> new ArrayList<>()).add(new Node(b, c));
            adj.computeIfAbsent(b, (t) -> new ArrayList<>()).add(new Node(a, c));
        }

        dijkstra(0);

        if (dist[N - 1] == Long.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(dist[N - 1] + "");
        }

        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0L));
        dist[start] = 0L;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.pos] < now.dist) continue;
            for (Node next : adj.getOrDefault(now.pos, new ArrayList<>())) {
                long nextDist = now.dist + next.dist;
                if (nextDist < dist[next.pos]) {
                    pq.add(new Node(next.pos, nextDist));
                    dist[next.pos] = nextDist;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int pos;
        long dist;

        public Node(int pos, long dist) {
            this.pos = pos;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

}
