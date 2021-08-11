package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15092
 * 2. 풀이
 *  - BFS를 이용한 영역별 번호 붙이기 문제
 */
public class bfs_15092_shebaAmoebas {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};

    static int[][] map;

    static void setArea(Point start, int no) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = no;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
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

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[j] == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }

        int no = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == -1) {
                    setArea(new Point(i, j), ++no);
                }
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
