package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/6129
 * 2. 풀이
 *   - 각 방향 진행으로의 최소값을 갱신해줌
 *   - 단, 역방향으로의 진행은 검토할 필요가 없음(최소 회전회수를 구해야하기 때문에)
 */
public class bfs_06129_obstacleCourse {

    static final int INF = 987654321;
    static final String DIRECTION = "북동남서";

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static int[][][] visit;
    static Point start, end;

    static void solve() {
        Queue<Point> q = new LinkedList<>();
        for(int dir = 0; dir < 4; dir++) {
            q.add(new Point(start.y, start.x, dir));
            visit[start.y][start.x][dir] = 0;
        }

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                if(Math.abs(now.dir - dir) == 2) continue; // 반대방향은 필요없음
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                int cnt = (now.dir == dir)? 0 : 1;
                if(ny < 0 || nx < 0 || N <= ny || N <= nx || map[ny][nx] == 'x') continue;
                if(visit[now.y][now.x][now.dir] + cnt < visit[ny][nx][dir]) {
                    visit[ny][nx][dir] = visit[now.y][now.x][now.dir] + cnt;
                    q.add(new Point(ny, nx, dir));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new int[N][N][4];

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                Arrays.fill(visit[i][j], INF);
                if(map[i][j] == 'A') {
                    start = new Point(i, j, 0);
                } else if(map[i][j] == 'B') {
                    end = new Point(i, j, 0);
                }
            }
        }

        solve();

        int ret = INF;
        for(int i = 0; i < 4; i++)
            ret = Math.min(ret, visit[end.y][end.x][i]);
        bw.write(ret + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int dir;
        public Point(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
