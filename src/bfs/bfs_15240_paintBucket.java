package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15240
 * 2. 풀이
 *  - 단순 BFS
 */
public class bfs_15240_paintBucket {

    static int R, C, K;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void solve(Point start) {
        int initColor = map[start.y][start.x];
        boolean[][] visit = new boolean[R][C];

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            map[now.y][now.x] = K;
            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] != initColor) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        K = Integer.parseInt(st.nextToken());

        solve(start);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
