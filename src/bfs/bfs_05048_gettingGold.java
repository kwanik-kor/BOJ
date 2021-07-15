package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5048
 * 2. 풀이
 *  - 금이 있다면 바로 진행할 수 있으나, 갈 수 있는 곳인데 사방에 트랩이 있다면 더 이상 진행할 수 없음
 */
public class bfs_05048_gettingGold {

    static int H, W;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;

    static Point start;

    static int solve() {
        boolean[][] visit = new boolean[H][W];
        int ret = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(isTrapAround(now))
                continue;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || H <= ny || W <= nx || visit[ny][nx] || map[ny][nx] == '#' || map[ny][nx] == 'T') continue;
                if(map[ny][nx] == 'G') {
                    ret++;
                    map[ny][nx] = '.';
                }
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    static boolean isTrapAround(Point p) {
        for(int dir = 0; dir < 4; dir++) {
            int ny = p.y + dy[dir];
            int nx = p.x + dx[dir];
            if(ny < 0 || nx < 0 || H <= ny || W <= nx) continue;
            if(map[ny][nx] == 'T')
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for(int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < W; j++) {
                if(map[i][j] == 'P') {
                    start = new Point(i, j);
                    map[i][j] = '.';
                }
            }
        }

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
