package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15242
 * 2. 풀이
 *  - 단순 BFS, 나이트의 움직임만 잘 만들어주면 됨
 */
public class bfs_15242_knight {

    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visit;

    static Point start, end;

    static int solve() {
        visit = new boolean[8][8];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now.n;

            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || 8 <= ny || 8 <= nx || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String startStr = br.readLine();
        start = new Point(startStr.charAt(0) - 'a', startStr.charAt(1) - '1', 0);
        String endStr = br.readLine();
        end = new Point(endStr.charAt(0) - 'a', endStr.charAt(1) - '1', 0);

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
