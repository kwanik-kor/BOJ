package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4956
 * 2. 풀이
 *  - 길찾기라는 단순한 BFS지만, 벽이 가로막고 있다.
 *  - 비트마스크로 내가 지정해 놓은 방향에 대해 벽을 설정해둔다.
 *  - 진행하고자 하는 방향으로 벽이 있는 경우에는 건너뛰고, 벽이 없으면 진행
 *  - 문제 상에서 최초 방에 진입하는 것도 횟수로 취급하기 때문에 최종 결과에 +1
 *    > BFS + Bitmask는 너무 재밋어!
 */
public class bfs_4956_amazingMazes {

    static int h, w;

    // 북 동 남 서(1, 2, 4, 8)
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;

    static int solve() {
        boolean[][] visit = new boolean[h][w];

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == h - 1 && now.x == w - 1)
                return now.n + 1;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || h <= ny || w <= nx || visit[ny][nx]) continue;
                // 진행하고자 하는 방향에 벽이 있다면
                if((map[now.y][now.x] & (1 << dir)) == (1 << dir)) continue;

                visit[ny][nx] = true;
                q.add(new Point(ny, nx, now.n + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String tmp = "";
        while(!(tmp = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(tmp);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            for(int t = 0; t < 2 * h - 1; t++) {
                st = new StringTokenizer(br.readLine());
                if(t % 2 == 0) { // 세로줄
                    int row = t / 2; // 행
                    for(int i = 0; i < w - 1; i++) {
                        int wall = Integer.parseInt(st.nextToken());
                        if(wall == 0) continue;
                        map[row][i] += 2; // 동쪽에 벽
                        if(i + 1 < w)
                            map[row][i + 1] += 8; // 서쪽에 벽
                    }
                } else { // 가로줄
                    int row = t / 2 + 1;
                    for(int i = 0; i < w; i++) {
                        int wall = Integer.parseInt(st.nextToken());
                        if(wall == 0) continue;
                        map[row][i] += 1; // 북쪽에 벽
                        map[row - 1][i] += 4; // 남쪽에 벽
                    }
                }
            }

            bw.write(solve() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int n;
        Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}
