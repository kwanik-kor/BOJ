package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16932
 * 2. 풀이
 *  - 1과 0의 지역을 미리 나눠두고, 1인 영역은 순회하면서 영역의 넓이와 넘버링을 진행
 *  - 0인 지역들을 순회하면서 주변 1인 영역의 넓이를 더해 최대 영역을 구함
 */
public class bfs_16932_makeShape {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static Map<Integer, Integer> shape;

    static void setArea(Point p, int no) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        map[p.y][p.x] = no;
        int area = 1;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] != -1) continue;
                map[ny][nx] = no;
                area++;
                q.add(new Point(ny, nx));
            }
        }

        shape.put(no, area);
    }

    static int getMaxArea(Point now) {
        HashSet<Integer> set = new HashSet<>();
        int ret = 1;
        for(int dir = 0; dir < 4; dir++) {
            int ny = now.y + dy[dir];
            int nx = now.x + dx[dir];
            if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] == 0 || set.contains(map[ny][nx])) continue;
            set.add(map[ny][nx]);
            ret += shape.get(map[ny][nx]);
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<Point> one = new ArrayList<>();
        List<Point> zero = new ArrayList<>();

        // Input을 받으면서 1과 0의 영역을 구분해서 저장해 둠
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    one.add(new Point(i, j));
                    map[i][j] = -1;
                } else {
                    zero.add(new Point(i, j));
                }
            }
        }

        // 1인 지역을 순회하면서 모양으로 묶고, 모양의 넓이를 결정
        shape = new HashMap<>();
        int no = 0;
        for(Point p : one) {
            if(map[p.y][p.x] == -1) {
                setArea(p, ++no);
            }
        }

        // 0인 지역을 순회하면서 최대 면적 계산
        int ans = 0;
        for(Point p : zero) {
            ans = Math.max(ans, getMaxArea(p));
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
