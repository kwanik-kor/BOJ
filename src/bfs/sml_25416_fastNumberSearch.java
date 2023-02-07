package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25416
 */
public class sml_25416_fastNumberSearch {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0 ,1, 0, -1};

    static int[][] map = new int[5][5];
    static int[][] visit = new int[5][5];

    static int bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visit[r][c] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];

                if (!canVisit(ny, nx)) continue;

                if (map[ny][nx] == 1) return visit[now.y][now.x] + 1;

                q.add(new Point(ny, nx));
                visit[ny][nx] = visit[now.y][now.x] + 1;
            }
        }

        return -1;
    }

    static boolean canVisit(int y, int x) {
        return 0 <= y && 0 <= x && y < 5 && x < 5 && visit[y][x] == -1 && map[y][x] != -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());

        bw.write(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "");
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
