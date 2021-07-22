package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1473
 * 2. 풀이
 *  - BFS와 비트마스킹을 이용한 경로 탐색
 */
public class bfs_01473_escapeMaze {

    static final int A = 15, B = 0, C = 5, D = 10;

    static int N, M;
    // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][][] map;
    static boolean[][][][] visit;

    static int solve() {
        visit = new boolean[N][M][1 << 7][1 << 7];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));
        visit[0][0][0][0] = true;

        int ret = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                if(now.y == N - 1 && now.x == M - 1) {
                    return ret;
                }

                for(int dir = 0; dir < 4; dir++) {
                    // 1. 현재 방에서 진행 방향에 문짝 달렸는가 체크
                    int tmpY = (now.yb & (1 << now.y)) != 0? 0 : 1;
                    int tmpX = (now.xb & (1 << now.x)) != 0? 0 : 1;
                    int turn = 0;
                    if(tmpY != tmpX) turn = 1;

                    // 1.1 다음 진행방향으로 문짝없으면 패스
                    if((map[now.y][now.x][turn] & (1 << dir)) != (1 << dir)) continue;

                    // 2. 다음 방향으로 체크
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];
                    if(ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx][now.yb][now.xb]) continue;

                    // 3. 다음 방에 문짝 달렸는가 체크
                    tmpY = (now.yb & (1 << ny)) != 0? 0 : 1;
                    tmpX = (now.xb & (1 << nx)) != 0? 0 : 1;
                    turn = 0;
                    if(tmpY != tmpX) turn = 1;

                    // 3.1 다음 방에 문짝 없으면 패스
                    if((map[ny][nx][turn] & (1 << dir)) != (1 << dir)) continue;

                    // 4. Queue 삽입
                    visit[ny][nx][now.yb][now.xb] = true;
                    q.add(new Point(ny, nx, now.yb, now.xb));
                }

                int ny = ((now.yb & (1 << now.y)) != 0)? now.yb - (1 << now.y) : (now.yb | (1 << now.y));
                int nx = ((now.xb & (1 << now.x)) != 0)? now.xb - (1 << now.x) : (now.xb | (1 << now.x));

                if(visit[now.y][now.x][ny][nx]) continue;
                visit[now.y][now.x][ny][nx] = true;
                q.add(new Point(now.y, now.x, ny, nx));
            }

            ret++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M][2];
        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0 ; j < M; j++) {
                switch (arr[j]) {
                    case 'A': // 네 짝 전부 다
                        map[i][j][0] = A;
                        map[i][j][1] = A;
                        break;
                    case 'C': // 남북
                        map[i][j][0] = C;
                        map[i][j][1] = D; // 회전하면 동서
                        break;
                    case 'D': // 동서
                        map[i][j][0] = D;
                        map[i][j][1] = C; // 회전하면 남북
                        break;
                    default: // 문 음슴
                        map[i][j][0] = B;
                        map[i][j][1] = B;
                }
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
        int yb;
        int xb;
        public Point(int y, int x, int yb, int xb) {
            this.y = y;
            this.x = x;
            this.yb = yb;
            this.xb = xb;
        }
    }
}
