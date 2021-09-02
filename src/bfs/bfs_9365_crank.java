package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9365
 * 2. 풀이
 *  - 블록의 가장자리에만 착지할 수 있음
 */
public class bfs_9365_crank {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Point start;
    static int[][] map;
    static boolean[][] visit;

    static int solve() {
        int ret = 0;

        visit[start.y][start.x] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == 0 || now.x == 0 || now.y == R - 1 || now.x == C - 1) {
                ret++;
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] < map[now.y][now.x] || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            visit = new boolean[R][C];

            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(String.format("Case #%d: %d\n", t, solve()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
