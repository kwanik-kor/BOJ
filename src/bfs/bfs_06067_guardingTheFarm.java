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
 * 1. 문제 링크: https://www.acmicpc.net/problem/6067
 * 2. 풀이
 *  - 고도가 높은 지역부터 영역을 지정하고, 순회하며 이미 방문한 높은 지역이 있다면 고점이 될 수 없음을 이용
 */
public class bfs_06067_guardingTheFarm {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    static boolean isTopOfHill(Point start, int n) {
        boolean ret = true;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx) continue;
                if(map[now.y][now.x] < map[ny][nx]) ret = false;
                if(visit[ny][nx] || map[ny][nx] != n) continue;

                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                points.add(new Point(i, j));
            }
        }
        points.sort((a, b) -> (map[b.y][b.x] - map[a.y][a.x]));

        int ans = 0;
        for(Point p : points) {
            if(!visit[p.y][p.x])
                ans += isTopOfHill(p, map[p.y][p.x])? 1 : 0;
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
