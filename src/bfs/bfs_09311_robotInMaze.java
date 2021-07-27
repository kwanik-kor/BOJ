package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/9311
 * 2. 풀이
 *  - 단순 BFS로 목적지 도착 가능 여부 및 최단거리 출력
 */
public class bfs_09311_robotInMaze {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static Point start;

    static int solve() {
        boolean[][] visit = new boolean[R][C];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(map[now.y][now.x] == 'G')
                return now.n;
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] == 'X' || map[ny][nx] == 'S')
                    continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            for(int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    if(map[i][j] == 'S')
                        start = new Point(i, j, 0);
                }
            }

            int ans = solve();
            bw.write(ans == -1? "No Exit\n" : String.format("Shortest Path: %d\n", ans));
        }


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
