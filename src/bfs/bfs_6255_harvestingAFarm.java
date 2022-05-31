package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6255
 * 2. 풀이
 *  - BFS로 각 농작물들의 구역을 우선 나눈다.
 *  - 다음으로, 각 구역별로 가장 많이 다른 영역과 마주하는 곳을 파악한다.
 *  - (전체 영역의 개수 - 가장 많은 경계의 수 + 1)이 정답이 된다 (단, 전체 영역의 개수 > 1)
 */
public class bfs_6255_harvestingAFarm {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m;
    static int maxBorder = 0;
    static int[][] map;
    static int[][] area;
    static boolean[][] visit;

    static void getMaxBorder(int idx, int y, int x) {
        Set<Integer> set = new HashSet<>();
        visit = new boolean[n][m];
        visit[y][x] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (ny < 0 || nx < 0 || n <= ny || m <= nx || visit[ny][nx]) continue;
                if (area[ny][nx] != idx) {
                    set.add(area[ny][nx]);
                    continue;
                }
                q.add(new Point(ny, nx));
                visit[ny][nx] = true;
            }
        }

        maxBorder = Math.max(maxBorder, set.size());
    }

    static void setArea(int idx, int y, int x) {
        int init = map[y][x];
        area[y][x] = idx;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (ny < 0 || nx < 0 || n <= ny || m <= nx || area[ny][nx] != 0 || map[ny][nx] != init) continue;
                area[ny][nx] = idx;
                q.add(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            map = new int[n][m];
            area = new int[n][m];
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (area[i][j] == 0) {
                        setArea(++cnt, i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j]) continue;
                    getMaxBorder(area[i][j], i, j);
                }
            }
            bw.write(cnt == 1 ? "1\n" : (cnt - maxBorder + 1 + "\n"));
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
