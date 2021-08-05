package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6004
 * 2. 풀이
 *  - Knight의 움직임만 구현해서, 시작점에서 도착점으로 가는 최단 거리를 구하는 것
 */
public class bfs_06004_chivalrousCow {

    static int R, C;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    static char[][] map;
    static Point start, end;

    static int solve() {
        boolean[][] visit = new boolean[R][C];
        visit[start.y][start.x] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now.n;
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] == '*')
                    continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'K')
                    start = new Point(i, j, 0);
                else if(map[i][j] == 'H')
                    end = new Point(i, j, 0);
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
