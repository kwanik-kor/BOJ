package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9204
 * 2. 풀이
 *  - 순수 BFS로 품
 *  - 근데 시간이 왜이래.... 시간 줄이도록 다시 풀어보3
 */
public class bfs_9204_chess {

    static final int SIZE = 8;

    static int[] dy = {1, 1, -1, -1};
    static int[] dx = {1, -1, 1, -1};
    static Point start, end;

    static Point solve() {
        boolean[][] visit = new boolean[SIZE][SIZE];

        Queue<Point> q = new LinkedList<Point>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now;

            for(int i = 0; i < 4; i++) {
                int ny = now.y;
                int nx = now.x;
                while(true) {
                    ny += dy[i];
                    nx += dx[i];

                    if(ny < 0 || nx < 0 || SIZE <= ny || SIZE <= nx) break;
                    if(visit[ny][nx] || now.cnt + 1 > 4) continue;

                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx, now.cnt + 1, now.path + getPosition(ny, nx)));
                }
            }
        }

        return new Point(-1, -1, -1, "Impossible");
    }

    static String getPosition(int y, int x) {
        return String.format(" %s %d", String.valueOf((char)(x + 'A')), y + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            char c1 = st.nextToken().charAt(0);
            int x1 = c1 - 'A';
            int y1 = Integer.parseInt(st.nextToken()) - 1;

            char c2 = st.nextToken().charAt(0);
            int x2 = c2 - 'A';
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            start = new Point(y1, x1, 0, String.valueOf(c1) + " " + (y1 + 1));
            end = new Point(y2, x2, 0, String.valueOf(c2) + " " + (y2 + 1));

            Point ret = solve();
            if(ret.cnt != -1)
                bw.write(ret.cnt + " ");
            bw.write(ret.path + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int cnt;
        String path;
        Point(int y, int x, int cnt, String path) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.path = path;
        }
    }
}
