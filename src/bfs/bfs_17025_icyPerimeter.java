package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17025
 * 2. 풀이
 *  - BFS 를 이용한 구역 나누기 및 면적, 둘레 구하기 문제
 *  - 크게 어려울 것은 없음
 * 3. 비고
 *  - 클래스 새로 만드는게 귀찮아서 면적과 둘레도 Point class를 사용했는데,
 *    일할 때는 이런 짓 절대 하지 말것!
 */
public class bfs_17025_icyPerimeter {

    static int N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static Point setArea(Point start, int idx) {
        int area = 1;
        int perimeter = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        map[start.y][start.x] = idx;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N + 2 <= ny || N + 2 <= nx) continue;
                if(map[ny][nx] == -1) {
                    perimeter++;
                    continue;
                }
                if(map[ny][nx] == 0) {
                    map[ny][nx] = idx;
                    area++;
                    q.add(new Point(ny, nx));
                }
            }
        }

        return new Point(area, perimeter);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 2][N + 2];
        for(int i = 0; i < N + 2; i++)
            Arrays.fill(map[i], -1);

        for(int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for(int j = 1; j <= N; j++) {
                if(tmp.charAt(j - 1) == '#')
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }

        int idx = 0;
        List<Point> li = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == 0) {
                    li.add(setArea(new Point(i, j), ++idx));
                }
            }
        }
        Collections.sort(li);

        bw.write(li.get(0).y + " " + li.get(0).x);
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int y; // 면적으로도 씀
        int x; // 둘레로도 씀
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point p) {
            if(this.y == p.y)
                return this.x - p.x;
            return p.y - this.y;
        }
    }
}
