package bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15972
 * 2. 풀이
 *   - 바깥으로 구멍이 뚫려 있는 곳부터 안쪽으로 좁혀들어오면서 높이를 갱신해준다.
 *   - 진행하고자 하는 방향의 물높이는 구멍의 높이와 현재 물의 높이를 비교하는 것이 포인트
 */
public class bfs_15972_waterTank {

    static int N, M, H;

    // 북 동 남 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] height = new int[1004][1004];
    static int[][][] hole = new int[1004][1004][4];

    static void solve(List<Point> points) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.addAll(points);
        while(!pq.isEmpty()) {
            Point now = pq.poll();
            if(height[now.y][now.x] != now.h) continue;
            for(int dir = 0; dir < 4; dir++) {
                // 진행 방향에 구멍이 없다면 pass
                if(hole[now.y][now.x][dir] == -1) continue;

                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 1 || nx < 1 || N < ny || M < nx) continue;
                int nextH = Math.max(height[now.y][now.x], Math.min(hole[now.y][now.x][dir], height[ny][nx]));

                if(nextH < height[ny][nx]) {
                    height[ny][nx] = nextH;
                    pq.add(new Point(ny, nx, nextH));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                int h = Integer.parseInt(st.nextToken());
                hole[i][j][0] = h;
                hole[i - 1][j][2] = h;
            }
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M + 1; j++) {
                int h = Integer.parseInt(st.nextToken());
                hole[i][j][3] = h;
                hole[i][j - 1][1] = h;
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                height[i][j] = H;
            }
        }

        List<Point> startPoints = new ArrayList<>();
        for(int i = 0; i <= N + 1; i++) {
            if(hole[i][0][1] != -1 && hole[i][0][1] < height[i][1]) {
                height[i][1] = hole[i][0][1];
                startPoints.add(new Point(i, 1, hole[i][0][1]));
            }
            if(hole[i][M + 1][3] != -1 && hole[i][M + 1][3] < height[i][M]) {
                height[i][M] = hole[i][M + 1][3];
                startPoints.add(new Point(i, M, hole[i][M + 1][3]));
            }
        }

        for(int i = 0; i <= M + 1; i++) {
            if(hole[0][i][2] != -1 && hole[0][i][2] < height[1][i]) {
                height[1][i] = hole[0][i][2];
                startPoints.add(new Point(1, i, hole[0][i][2]));
            }
            if(hole[N + 1][i][0] != -1 && hole[N + 1][i][0] < height[N][i]) {
                height[N][i] = hole[N + 1][i][0];
                startPoints.add(new Point(N, i, hole[N + 1][i][0]));
            }
        }

        solve(startPoints);

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                ans += height[i][j];
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int h;
        public Point(int y, int x, int h) {
            this.y = y;
            this.x = x;
            this.h = h;
        }

        @Override
        public int compareTo(Point p) {
            return this.h - p.h;
        }
    }
}
