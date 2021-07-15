package bfs;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9505
 * 2. 풀이
 *   - 클링온 전투선들을 부수는데 드는 cost가 가장 작은 경로를 통해서 map을 벗어나야 함
 *   - map을 벗어나야 하기 때문에 기존 map에서 안팎으로 바운더리를 하나 더 주고,
 *     PriorityQueue를 이용해서 최단 경로 찾아냄
 */
public class bfs_09505_escapeEnterprise {

    static int K, W, H;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] cost;
    static int[][] map;
    static Point start;

    static int solve() {
        boolean[][] visit = new boolean[H + 2][W + 2];
        visit[start.y][start.x] = true;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(start);
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            if(now.y == 0 || now.x == 0 || now.y == H + 1 || now.x == W + 1)
                return now.n;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || H + 1 < ny || W + 1 < nx || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                pq.add(new Point(ny, nx, now.n + map[ny][nx]));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H + 2][W + 2];
            cost = new int[26];
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                cost[st.nextToken().charAt(0) - 'A'] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= H; i++) {
                String tmp = br.readLine();
                for(int j = 1; j <= W; j++) {
                    map[i][j] = cost[tmp.charAt(j - 1) - 'A'];
                    if(tmp.charAt(j - 1) == 'E') {
                        start = new Point(i, j, 0);
                        map[i][j] = 0;
                    }
                }
            }

            bw.write(solve() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int n;
        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }

        @Override
        public int compareTo(Point p) {
            return this.n - p.n;
        }
    }
}
