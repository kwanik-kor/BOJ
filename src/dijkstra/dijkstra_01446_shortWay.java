package dijkstra;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1446
 * 2. 풀이
 *  - dijkstra에 앞서 PriorityQueue로 한 번 풀어봄
 *   >> dijkstra로 다시 풀어라~
 */
public class dijkstra_01446_shortWay {

    static final int INF = 987654321;

    static int D;
    static int[] dist;
    static Map<Integer, List<Node>> map;

    static void solve() {
        dist = new int[D + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int next_1 = now.pos + 1;
            if(next_1 > D) continue;
            if(now.dist + 1 < dist[next_1]) {
                dist[next_1] = now.dist + 1;
                pq.add(new Node(next_1, now.dist + 1));
            }

            if(map.containsKey(now.pos)) {
                for(Node next : map.get(now.pos)) {
                    if(now.dist + next.dist < dist[next.pos]) {
                        dist[next.pos] = now.dist + next.dist;
                        pq.add(new Node(next.pos, now.dist + next.dist));
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(D < b) continue;

            List<Node> tempLi = map.getOrDefault(a, new ArrayList<>());
            tempLi.add(new Node(b, c));
            map.put(a, tempLi);
        }

        solve();

        bw.write(dist[D] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int pos;
        int dist;

        public Node(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            if(n.pos == this.pos)
                return this.dist - n.dist;
            return n.pos - this.pos;
        }
    }
}
