package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4993
 */
public class bfs_04993_redAndBlack {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;

    static Point start;

    static int solve() {
        int ret = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || visit[ny][nx] || map[ny][nx] == '#') continue;
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
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if(R == 0 && C == 0)
                break;

            map = new char[R][C];
            visit = new boolean[R][C];
            for(int i = 0; i < R; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < C; j++) {
                    if(map[i][j] == '@')
                        start = new Point(i, j);
                }
            }

            bw.write(solve() + "\n");
        }


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
