package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5980
 * 2. 풀이
 *  - 조건이 중요한 문제였음.
 *   > Slide 를 만나면 반드시 타야 한다는 점이 핵심
 *   > Slide 의 출발점만을 방문처리하고 q에는 도착점을 집어 넣음
 */
public class bfs_5980_cornMaze {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;

    static Point start, end;
    static Map<Character, List<Point>> slides;

    // 조건 1 : Slide에 발올리면 바로 타야됨
    static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x)
                return now.n;
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx] || map[ny][nx] == '#') continue;

                visit[ny][nx] = true;

                // slide 라면
                if('A' <= map[ny][nx] && map[ny][nx] <= 'Z') {
                    Point next = null;
                    for(Point p : slides.get(map[ny][nx])) {
                        if(p.y != ny || p.x != nx)
                            next = p;
                    }

                    if(next != null) {
                        q.add(new Point(next.y, next.x, now.n + 1));
                    }
                } else {
                    q.add(new Point(ny, nx, now.n + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];
        slides = new HashMap<>();
        for(int i = 0; i < 26; i++)
            slides.put((char)(i + 'A'), new ArrayList<>());

        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(map[i][j] == '=')
                    end = new Point(i, j, 0);
                else if(map[i][j] == '@')
                    start = new Point(i, j, 0);
                else if('A' <= map[i][j] && map[i][j] <= 'Z')
                    slides.get(map[i][j]).add(new Point(i, j, 0));
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
        int n;
        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}
