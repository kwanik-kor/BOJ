package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6146
 * 2. 풀이
 *  - 단순 BFS
 *  - (-500 ~ 500) 까지가 좌표가 존재할 수 있는 범위기 때문에,
 *    이것만 배열 상에서 잘 표현해준다면 큰 무리 없이 풀 수 있음
 */
public class bfs_06146_toMeetSina {

    static final int ABS = 500;

    static int X, Y, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(500, 500, 0));
        map[500][500] = -1;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == X && now.x == Y)
                return now.n;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || 1001 <= ny || 1001 <= nx || map[ny][nx] == -1) continue;
                map[ny][nx] = -1;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()) + ABS;
        Y = Integer.parseInt(st.nextToken()) + ABS;
        N = Integer.parseInt(st.nextToken());

        map = new int[1001][1001];
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) + ABS][Integer.parseInt(st.nextToken()) + ABS] = -1;
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
