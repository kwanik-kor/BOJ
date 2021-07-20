package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18422
 * 2. 풀이
 *  - BFS를 활용한 구역 나누기의 기본적인 문제
 */
public class bfs_18422_emacs {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static void setArea(Point p, int no) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        map[p.y][p.x] = no;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = no;
                q.add(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Point> li = new ArrayList<>();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = arr[j] == '.'? 0 : -1;
                if(map[i][j] == -1)
                    li.add(new Point(i, j));
            }
        }

        int no = 0;
        for(Point p : li) {
            if(map[p.y][p.x] == -1) {
                setArea(p, ++no);
            }
        }

        bw.write(no + "");
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
