package bfs;

import java.io.*;
import java.util.*;

/**
 *  1. 문제 링크 : https://www.acmicpc.net/problem/1245
 *  2. 풀이
 *   - It can be simply solved by BFS Algorithm(Why I can't type Korean Letter;;;)
 *   - There is a trap on a question which related in direction
 *    >> 'Adjacent' means 8 direction including diagonal on this question.
 */
public class bfs_01245_manageFarm {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};

    static int[][] map;
    static boolean[][] visit;

    static boolean isTop(Point p) {
        boolean ret = true;

        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visit[p.y][p.x] = true;
        int height = map[p.y][p.x];
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx) continue;
                if(height < map[ny][nx])
                    ret = false;
                if(!visit[ny][nx] && map[ny][nx] == height) {
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx));
                }
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
        visit = new boolean[N][M];
        List<Point> mountain = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)
                    mountain.add(new Point(i, j));
            }
        }

        int ans = 0;
        for(Point p : mountain) {
            if(!visit[p.y][p.x]) {
                ans += isTop(p)? 1 : 0;
            }
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
