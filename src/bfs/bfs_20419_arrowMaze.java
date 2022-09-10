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
 * 1. 문제 링크: https://www.acmicpc.net/problem/20419
 */
public class bfs_20419_arrowMaze {

    static final String DIR_STR = "URDL";

    static int R, C, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static boolean solve() {
        boolean[][][] visit = new boolean[R][C][4];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.y == R - 1 && now.x == C - 1) {
                return true;
            }

            int dir = map[now.y][now.x];
            int ny = now.y + dy[dir];
            int nx = now.x + dx[dir];

            if (!outOfRange(ny, nx) && !visit[ny][nx][now.flag]) {
                q.add(new Point(ny, nx, now.flag));
                visit[ny][nx][now.flag] = true;
            }

            if (K == 0) continue;
            if ((now.flag & 1) == 0) {
                int nextFlag = now.flag | 1;
                int nextDir = (dir - 1 < 0) ? 3 : dir - 1;

                ny = now.y + dy[nextDir];
                nx = now.x + dx[nextDir];
                if (!outOfRange(ny, nx) && !visit[ny][nx][nextFlag]) {
                    q.add(new Point(ny, nx, nextFlag));
                    visit[ny][nx][nextFlag] = true;
                }
            }

            if ((now.flag & 2) == 0) {
                int nextFlag = now.flag | 2;
                int nextDir = (dir + 1) % 4;

                ny = now.y + dy[nextDir];
                nx = now.x + dx[nextDir];
                if (!outOfRange(ny, nx) && !visit[ny][nx][nextFlag]) {
                    q.add(new Point(ny, nx, nextFlag));
                    visit[ny][nx][nextFlag] = true;
                }
            }
        }
        return false;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || R <= y || C <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = DIR_STR.indexOf(line[j]);
            }
        }

        bw.write(solve() ? "Yes" : "No");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y, x, flag;

        public Point(int y, int x, int flag) {
            this.y = y;
            this.x = x;
            this.flag = flag;
        }
    }
}
