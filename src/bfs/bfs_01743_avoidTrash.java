package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1743
 * 2. 풀이
 *  - BFS로 구역나누기 기초 문제
 */
public class bfs_01743_avoidTrash {

    static int N, M, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ans = 0;
    static int[][] map;

    static int getSize(Point p) {
        int ret = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(p);
        map[p.y][p.x] = -1;
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
        K = Integer.parseInt(st.nextToken());

        List<Point> trashes = new ArrayList<>();
        map = new int[N][M];
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
            trashes.add(new Point(a, b));
        }

        for(Point trash : trashes) {
            if(map[trash.y][trash.x] == 1)
                ans = Math.max(ans, getSize(trash));
        }

        bw.write(ans + "");
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
