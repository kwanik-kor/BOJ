package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5143
 * 2. 풀이
 *  - 기름이 얼마나 묻었는지 여부를 확인하기 위해 visit 배열을 3차원 배열로 이용
 *  - 기름에 한 번 묻으면 이것이 없어진다는 조건은 없었기 때문에, 지나갈 때마다 새로 묻어야 함
 */
public class bfs_5143_seymourTheSeal {

    static int M, N;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;

    static Point start;

    static int solve() {
        boolean[][][] visit = new boolean[N][M][4];
        int cnt = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x][0] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];

                if(ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx][now.n]) continue;

                if(map[ny][nx] == '.') {
                    visit[ny][nx][now.n] = true;
                    q.add(new Point(ny, nx, now.n));
                } else if(map[ny][nx] == 'G' && now.n + 1 < 4) {
                    visit[ny][nx][now.n + 1] = true;
                    q.add(new Point(ny, nx, now.n + 1));
                } else if(map[ny][nx] == 'P') {
                    visit[ny][nx][now.n] = true;
                    q.add(new Point(ny, nx, 0));
                } else if(map[ny][nx] == 'H') {
                    visit[ny][nx][now.n] = true;
                    map[ny][nx] = '.';
                    cnt++;
                    q.add(new Point(ny, nx, now.n));
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for(int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];

            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 'S') {
                        start = new Point(i, j, 0);
                        map[i][j] = '.';
                    }
                }
            }

            bw.write(String.format("Data Set %d:\n%d\n\n", k, solve()));
        }

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
