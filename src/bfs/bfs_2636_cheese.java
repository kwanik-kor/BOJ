package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2636
 * 2. 풀이
 *  - 바깥 공기를 기준으로 bfs를 진행해야 함.
 *  - 처음 한 번 bfs를 돌려서 최초 바깥 공기를 파악한 후, 치즈를 순차적으로 녹이게끔 작업
 *  - bitmask를 사용할 경우 좀 더 빠른 풀이가 가능할 것으로 보임.
 */
public class bfs_2636_cheese {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;

    static int size;
    static int time;
    static int lastCnt;

    static void solve(List<Point> points) {
        Queue<Point> q = new LinkedList<Point>();
        for(Point p : points) {
            visit[p.y][p.x] = true;
            q.add(p);
        }

        time = 0;
        lastCnt = size;
        while(!q.isEmpty()) {
            if(size == 0) return;

            int qSize = q.size();
            List<Point> cheese = new ArrayList<Point>();
            List<Point> newAirs = new ArrayList<Point>();

            while(qSize-- > 0) {
                Point now = q.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = now.y + dy[i];
                    int nx = now.x + dx[i];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == -1) continue;

                    visit[ny][nx] = true;

                    // 안쪽 공기
                    if(map[ny][nx] == 0) {
                        newAirs.add(new Point(ny, nx));
                        continue;
                    }
                    // 치즈
                    cheese.add(new Point(ny, nx));
                    q.add(new Point(ny, nx));
                }
            }

            lastCnt = size;
            time++;
            // 치즈 녹이기
            for(Point p : cheese) {
                map[p.y][p.x] = -1;
                size--;
            }
            // 안쪽 공기 바깥 공기화
            newAirs.addAll(cheese);
            q.addAll(findAir(newAirs));
        }
    }

    static List<Point> findAir(List<Point> points) {
        List<Point> airs = new ArrayList<Point>();

        Queue<Point> q = new LinkedList<Point>();
        for(Point p : points) {
            map[p.y][p.x] = -1;
            q.add(p);
            airs.add(p);
        }

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 0) continue;
                if(map[ny][nx] == 0) {
                    map[ny][nx] = -1;
                    airs.add(new Point(ny, nx));
                    q.add(new Point(ny, nx));
                }
            }
        }

        return airs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        size = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 치즈라면.. 먹고싶다..
                if(map[i][j] == 1) {
                    size++;
                }
            }
        }

        List<Point> starts = findAir(Arrays.asList(new Point(0, 0)));
        solve(starts);

        bw.write(time + "\n" + lastCnt);

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
