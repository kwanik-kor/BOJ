package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1926
 * 2. 풀이
 *  - BFS로 영역을 구분하는 가장 기본적인 문제 중 하나
 */
public class bfs_01926_picture {

    static int N, M;
    static int ans = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static int getArea(Point point) {
        int ret = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(point);
        map[point.y][point.x] = -1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] != 1) continue;
                map[ny][nx] = -1;
                ret++;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<Point> pictures = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    pictures.add(new Point(i, j));
            }
        }

        int cnt = 0;
        for(Point p : pictures) {
            if(map[p.y][p.x] == 1) {
                cnt++;
                ans = Math.max(ans, getArea(p));
            }
        }

        bw.write(String.format("%d\n%d", cnt, ans));
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
