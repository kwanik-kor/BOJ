package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_12887_pathGame {

    static int M;
    static int white = 0, black = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static int bfs(Point start) {
        boolean[][] visit = new boolean[2][M];

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.x == M - 1)
                return now.n;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || 2 <= ny || M <= nx || map[ny][nx] == -1 || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        M = Integer.parseInt(br.readLine());

        map = new int[2][M];
        for(int i = 0; i < 2; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[j] == '#') {
                    black++;
                    map[i][j] = -1;
                } else {
                    white++;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 2; i++) {
            if(map[i][0] != -1) {
            }
        }


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
