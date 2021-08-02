package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14546
 * 2. 풀이
 *  - BFS로 경로를 찾으면 되는 문제
 *  - 딱히 어려울 것은 하나도 없으나, 문제의 시작점과 도착점의 좌표만 헷갈리지 않게 잘 설정해주면 됨
 */
public class bfs_14546_prisonBreak {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;

    static Point start, end;

    static boolean solve() {
        char type = map[start.y][start.x];

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return true;
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] != type) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }


        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        while(P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            visit = new boolean[R][C];

            int x, y;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            start = new Point(R - y , x - 1);

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new Point(R - y , x - 1);

            for(int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }

            bw.write(solve()? "YES\n" : "NO\n");
        }
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
