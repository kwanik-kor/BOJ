package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6189
 * 2. 풀이
 *  - BFS를 이용한 단순 경로찾기
 *   --> 문제 난이도 레벨 낮춰야할듯..?
 */
public class bfs_06189_munching {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static Point start, end;

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = 1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return map[now.y][now.x] - 1;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != 0) continue;
                map[ny][nx] = map[now.y][now.x] + 1;
                q.add(new Point(ny, nx));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(tmp[j] == 'B')
                    end = new Point(i, j);
                else if(tmp[j] == 'C')
                    start = new Point(i, j);
                else if(tmp[j] == '*')
                    map[i][j] = -1;
            }
        }

        bw.write(bfs() + "");

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
