package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16948
 * 2. 풀이
 *  - 단순 BFS...
 *  - 체스의 일반적인 Knight 움직임으로 풀면 안됨. 문제에서 제시해준 방향으로 움직일것~
 */
public class bfs_16948_deathKnight {

    static int N;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2 ,2, -1, 1};
    static int[][] map;
    static Point start, end;

    static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return map[now.y][now.x];

            for(int dir = 0; dir < 6; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = map[now.y][now.x] + 1;
                q.add(new Point(ny, nx));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(map[i], -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(solve() + "");
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
