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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24463
 * 2. 풀이
 *  - 최단거리 탐색 시, 발견한 경로에 대해 노드로 기록을 남겨둔다.
 *  - 최종 탐색을 마친 후에 기록을 역으로 추적하여 경로를 표시한다.
 */
public class bfs_24463_maze {

    static final char WALL = '+', PATH = '.', UNVISITED = '@';

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static int[][] path;
    static Point start, end;

    static void solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        path[start.y][start.x] = start.y * M + start.x;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                break;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(outOfRange(ny, nx) || path[ny][nx] != 0 || map[ny][nx] == WALL) continue;
                path[ny][nx] = now.y * M + now.x;
                q.add(new Point(ny, nx));
            }
        }

        checkVisitedPath();
    }

    static void checkVisitedPath() {
        int y = end.y;
        int x = end.x;
        while(true) {
            map[y][x] = PATH;
            int ny = path[y][x] / M;
            int nx = path[y][x] % M;
            if(y == ny && x == nx)
                break;
            y = ny;
            x = nx;
        }
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || M <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        path = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if(map[i][j] == PATH) map[i][j] = UNVISITED;
                if((i == 0 || i == N - 1|| j == 0 || j == M - 1) && map[i][j] == UNVISITED) {
                    if(start == null) start = new Point(i, j);
                    else end = new Point(i, j);
                }
            }
        }

        solve();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
