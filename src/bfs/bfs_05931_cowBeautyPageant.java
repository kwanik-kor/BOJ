package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5931
 * 2. 풀이
 *  - 두 영역의 그리드를 선정해두고, 첫 번째 그리드에서 두 번째 그리드로 가장 빨리가는 경로를 찾으면 됨
 */
public class bfs_05931_cowBeautyPageant {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static int getShortest(List<Point> points) {
        int ret = 0;
        boolean[][] visit = new boolean[R][C];

        Queue<Point> q = new LinkedList<>(points);
        for(Point p : points) {
            visit[p.y][p.x] = true;
        }

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                if(map[now.y][now.x] == 2) {
                    return ret - 1;
                }
                for(int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];
                    if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    q.add(new Point(ny, nx));
                }
            }

            ret++;
        }

        return ret;
    }

    static void setGrid(Point start, int no) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = no;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = no;
                Point next = new Point(ny, nx);
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(arr[j] == '.')
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }

        int no = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == -1) {
                    setGrid(new Point(i, j), ++no);
                }
            }
        }

        List<Point> first = new ArrayList<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 1)
                    first.add(new Point(i, j));
            }
        }

        bw.write(getShortest(first) + "");
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
