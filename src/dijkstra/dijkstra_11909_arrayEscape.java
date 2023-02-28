package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11909
 */
public class dijkstra_11909_arrayEscape {
    static final int[] dy = {1, 0};
    static final int[] dx = {0, 1};

    static int N;
    static int[][] map;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();

        bw.write(visit[N - 1][N - 1] + "");
        bw.close();
        br.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        visit[0][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int y = now.pos / N;
            int x = now.pos % N;

            if (visit[y][x] < now.dist) continue;

            for (int dir = 0; dir < 2; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || nx < 0 || N <= ny || N <= nx) continue;

                int dist = now.dist + (map[y][x] > map[ny][nx] ? 0 : map[ny][nx] - map[y][x] + 1);

                if (dist < visit[ny][nx]) {
                    pq.add(new Node(ny * N + nx, dist));
                    visit[ny][nx] = dist;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int pos, dist;

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
