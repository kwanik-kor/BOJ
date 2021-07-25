package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6229
 * 2. 풀이
 *  - 체스의 나이트와 같은 움직임을 John이 갖게 되는데,
 *    M1과 M2를 이용해 Direction만 잘 잡아주면 문제없이 풀 수 있음
 */
public class bfs_06229_bronzeLilypad {

    static int M, N;
    static int[] dy = {-1, -1, 1, 1};
    static int[] dx = {1, -1, 1, -1};
    static int[] dm;

    static int[][] map;
    static Point start, end;

    static int solve() {
        boolean[][] visit = new boolean[M][N];

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now.n;
            for(int dir = 0; dir < 4; dir++) {
                for(int m = 0; m < 2; m++) {
                    int ny = now.y + dy[dir] * dm[m];
                    int nx = now.x + dx[dir] * dm[1 - m];
                    if(ny < 0 || nx < 0 || M <= ny || N <= nx || visit[ny][nx] || map[ny][nx] != 1) continue;
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx, now.n + 1));
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dm = new int[2];
        dm[0] = Integer.parseInt(st.nextToken());
        dm[1] = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 3) {
                    map[i][j] = 1;
                    start = new Point(i, j, 0);
                } else if(map[i][j] == 4) {
                    map[i][j] = 1;
                    end = new Point(i, j, 0);
                }
            }
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int n;
        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}
