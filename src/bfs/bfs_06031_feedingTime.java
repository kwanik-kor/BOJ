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
 * 1. 문제 링크: https://www.acmicpc.net/problem/6031
 * 2. 풀이
 *  - 구역별로 탐색을 진행하며 구역의 면적과 최대면적을 비교 갱신해준다.
 */
public class bfs_06031_feedingTime {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static char[][] map;

    static int ans = 0;

    static void setArea(Point start) {
        int tot = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = '*';
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != '.') continue;
                map[ny][nx] = '*';
                tot++;
                q.add(new Point(ny, nx));
            }
        }

        ans = Math.max(ans, tot);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == '.')
                    setArea(new Point(i, j));
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
