package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5206
 * 2. 풀이
 *  - 단순 구현 문제... 문제 레벨에 비해서는 할게 좀 많다..?
 */
public class bfs_05206_lunch {

    static final int INF = 987654321;

    static int H, W;
    static int ans;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static int startPointCnt;
    static List<Point> meetingPoints;
    static List<Point> restaurants;

    static void getDist(Point m, Point r) {
        // meeting point -> start points
        int dist_1 = getDistPlacetoStart(m);
        if(dist_1 == -1) return;

        // meeting point -> restaurant
        int dist_2 = getDistMtoR(m, r);
        if(dist_2 == -1) return;

        // restaurant -> start points
        int dist_3 = getDistPlacetoStart(r);
        if(dist_3 == -1) return;

        ans = Math.min(ans, dist_1 + dist_2 + dist_3);
    }

    static int getDistPlacetoStart(Point m) {
        int[][] visit = new int[H][W];
        int ret = 0;
        int cnt = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(m);
        visit[m.y][m.x] = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(map[now.y][now.x] == 'S') {
                cnt++;
                ret += visit[now.y][now.x] - 1;
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || H <= ny || W <= nx || visit[ny][nx] != 0 || map[ny][nx] == 'X' || map[ny][nx] == 'R') continue;
                visit[ny][nx] = visit[now.y][now.x] + 1;
                q.add(new Point(ny, nx));
            }
        }

        return cnt == startPointCnt? ret : -1;
    }

    static int getDistMtoR(Point m, Point r) {
        int[][] visit = new int[H][W];

        Queue<Point> q = new LinkedList<>();
        q.add(m);
        visit[m.y][m.x] = 1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == r.y && now.x == r.x) {
                return (visit[now.y][now.x] - 1) * startPointCnt;
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || H <= ny || W <= nx || visit[ny][nx] != 0 || map[ny][nx] == 'X') continue;
                if(map[ny][nx] == 'R' && ny != r.y && nx != r.x) continue;
                visit[ny][nx] = visit[now.y][now.x] + 1;
                q.add(new Point(ny, nx));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            startPointCnt = 0;
            map = new char[H][W];
            meetingPoints = new ArrayList<>();
            restaurants = new ArrayList<>();
            for(int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < W; j++) {
                    if(map[i][j] == 'M')
                        meetingPoints.add(new Point(i, j));
                    else if(map[i][j] == 'R')
                        restaurants.add(new Point(i, j));
                    else if(map[i][j] == 'S')
                        startPointCnt++;
                }
            }

            ans = INF;
            for(Point m : meetingPoints) {
                for(Point r : restaurants) {
                    getDist(m, r);
                }
            }
            if(ans == INF) {
                bw.write(String.format("Data Set %d:\nImpossible\n", t));
            } else {
                bw.write(String.format("Data Set %d:\n%d\n", t, ans));
            }
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
