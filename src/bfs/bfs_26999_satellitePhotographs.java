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
 * 1. 문제 링크: https://www.acmicpc.net/problem/26999
 */
public class bfs_26999_satellitePhotographs {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int R, C;
    static char[][] map;
    static boolean[][] visit;

    static int solve() {
        int ret = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && map[i][j] == '*') {
                    ret = Math.max(ret, search(i, j));
                }
            }
        }

        return ret;
    }

    static int search(int y, int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y * C + x);
        visit[y][x] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            int nowY = now / C;
            int nowX = now % C;

            for (int dir = 0; dir < 4; dir++) {
                int ny = nowY + dy[dir];
                int nx = nowX + dx[dir];
                if (!canVisit(ny, nx)) continue;
                q.add(ny * C + nx);
                visit[ny][nx] = true;
                cnt++;
            }
        }

        return cnt;
    }

    static boolean canVisit(int y, int x) {
        return 0 <= y && 0 <= x && y < R && x < C && !visit[y][x] && map[y][x] == '*';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
