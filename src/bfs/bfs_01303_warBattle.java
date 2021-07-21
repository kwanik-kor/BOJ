package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1303
 * 2. 풀이
 *  - BFS 로 구역 나누기
 */
public class bfs_01303_warBattle {

    static int M, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visit;

    static int bfs(Point p, char team) {
        int ret = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visit[p.y][p.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || M <= ny || N <= nx || visit[ny][nx] || map[ny][nx] != team) continue;
                ret++;
                visit[ny][nx] = true;
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

        map = new char[M][N];
        visit = new boolean[M][N];
        for(int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int w = 0;
        int b = 0;

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    int cnt = bfs(new Point(i, j), map[i][j]);
                    if(map[i][j] == 'W')
                        w += cnt * cnt;
                    else
                        b += cnt * cnt;
                }
            }
        }

        bw.write(w + " " + b);
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
