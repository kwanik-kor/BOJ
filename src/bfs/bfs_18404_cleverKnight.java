package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/18404
 * 2. 풀이
 *  - 나이트의 움직임만 잘 만들면 됨
 *  - 시작점에서 모든 상대 말들을 잡는 경로가 아니기 때문에,
 *    시작점에서 이동할 수 있는 모든 최소 경로를 미리 표시해두고
 *    Query 를 해결
 */
public class bfs_18404_cleverKnight {

    static int N, M;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;

    static void move(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = now.n + 1;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(map[i], -1);

        st = new StringTokenizer(br.readLine());
        move(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            bw.write(map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] + " ");
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
