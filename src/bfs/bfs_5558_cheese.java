package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5558
 * 2. 풀이
 *  - 단순 BFS로, cheese에 도달할 때마다 방문지점을 갱신해주면 됨
 */
public class bfs_5558_cheese {

    static int H, W, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;

    static Point start;
    static Map<Integer, Point> factory;

    static int solve() {
        boolean[][] visit = new boolean[H][W];
        int cheese = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if((int)(map[now.y][now.x] - '0') == cheese + 1) {
                cheese++;

                visit = new boolean[H][W];
                q = new LinkedList<>();

                q.add(new Point(now.y, now.x, now.n));
                visit[now.y][now.x] = true;
            }
            if(cheese == N)
                return now.n;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || H <= ny || W <= nx || visit[ny][nx] || map[ny][nx] == 'X') continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        factory = new HashMap<>();
        for(int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                if(map[i][j] == 'S') {
                    start = new Point(i, j, 0);
                    map[i][j] = '.';
                }
                if('1' <= map[i][j] && map[i][j] <= '9')
                    factory.put((int)(map[i][j] - '0'), new Point(i, j, 0));
            }
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
