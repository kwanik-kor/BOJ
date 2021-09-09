package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/13903
 * 2. 풀이
 *  - 시작할 수 있는 모든 노드를 추가하고 시작해서 동시에 도착하게 처리
 */
public class bfs_13903_goToWork {

    static final int INF = 987654321;

    static int R, C, N;
    static int[] dy;
    static int[] dx;

    static int[][] map;
    static boolean[][] visit;

    static int getDist(List<Point> start) {
        Queue<Point> q = new LinkedList<>(start);

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == R - 1)
                return now.n;

            for(int dir = 0; dir < N; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || R <= ny || C <= nx || map[ny][nx] != 1 || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }

        }

        return INF;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visit = new boolean[R][C];
        List<Point> starts = new ArrayList<>();
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0 && map[i][j] == 1) {
                    starts.add(new Point(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }
        N = Integer.parseInt(br.readLine());
        dy = new int[N];
        dx = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dy[i] = Integer.parseInt(st.nextToken());
            dx[i] = Integer.parseInt(st.nextToken());
        }

        int ans = getDist(starts);

        bw.write((ans == INF? -1 : ans) + "");
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
