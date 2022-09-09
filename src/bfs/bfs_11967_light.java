package bfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11967
 * 2. 풀이
 *  - 불을 켜진 위치와 불을 켠 장소에 대해서 비트 연산을 통해 플래그로 표기한다.
 *  - 특정 위치에서 불을 켤 경우 방문에 대한 기록을 초기화 하고 다시 loop를 진행한다.
 */
public class bfs_11967_light {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;
    static int[][] light;
    static Map<Integer, List<Point>> switches = new HashMap<>();

    static int solve() {
        boolean[][] visit = new boolean[N][N];
        int cnt = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            boolean hasTurnOn = false;

            Point now = q.poll();
            if ((light[now.y][now.x] & 2) != 2) {
                for (Point p : switches.get(now.y * N + now.x)) {
                    if ((light[p.y][p.x] & 1) == 1) continue;
                    light[p.y][p.x] |= 1;
                    cnt++;
                    hasTurnOn = true;
                }
                light[now.y][now.x] |= 2;
            }

            if (hasTurnOn) {
                IntStream.range(0, N).forEach(idx -> Arrays.fill(visit[idx], false));
                visit[now.y][now.x] = true;
                while (!q.isEmpty()) q.poll();
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (outOfRange(ny, nx) || light[ny][nx] == 0 || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return cnt;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        light = new int[N][N];
        light[0][0] = 1;
        IntStream.range(0, N * N)
                .forEach(idx -> switches.put(idx, new ArrayList<>()));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int node = y1 * N + x1;
            switches.get(node).add(new Point(y2, x2));
        }

        bw.write(solve() + "");
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
