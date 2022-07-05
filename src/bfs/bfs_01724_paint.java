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
 * 1. 문제 링크: https://www.acmicpc.net/problem/1724
 * 2. 풀이
 *  - 비트마스킹을 이용해 지나갈 수 없는 벽을 생성
 *  - 동일한 위치를 지나는 선분이 있을 수 있다는 점을 인지하지 못해 두번 틀림
 */
public class bfs_01724_paint {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] flag = {1, 2, 4, 8};

    static int[][] map;
    static boolean[][] visit;

    static int setArea(int y, int x) {
        int cnt = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx]) continue;
                if ((map[now.y][now.x] & flag[dir]) == flag[dir]) continue;
                visit[ny][nx] = true;
                cnt++;
                q.add(new Point(ny, nx));
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            if (y1 == y2) {
                int minX = Math.min(x1, x2);
                int maxX = Math.max(x1, x2);
                for (int idx = minX; idx < maxX; idx++) {
                    if (0 <= y1 - 1 && (map[y1 - 1][idx] & flag[2]) == 0) {
                        map[y1 - 1][idx] += flag[2];
                    }
                    if (y1 < N && ((map[y1][idx] & flag[0]) == 0)) {
                        map[y1][idx] += flag[0];
                    }
                }
            } else {
                int minY = Math.min(y1, y2);
                int maxY = Math.max(y1, y2);
                for (int idx = minY; idx < maxY; idx++) {
                    if (0 <= x1 - 1 && ((map[idx][x1 - 1] & flag[1]) == 0)) {
                        map[idx][x1 - 1] += flag[1];
                    }
                    if (x1 < M && ((map[idx][x1] & flag[3]) == 0)) {
                        map[idx][x1] += flag[3];
                    }
                }
            }
        }

        int max = 0;
        int min = N * M + 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    int size = setArea(i, j);
                    max = Math.max(max, size);
                    min = Math.min(min, size);
                }
            }
        }


        bw.write(max + "\n" + min);
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
