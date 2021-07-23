package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/14451
 * 2. 풀이
 *  - 구슬 탈출과 유사하게 두 노드(위에 보고 있는 러너, 오른쪽 보고 있는 러너)가 동시에 출발, 움직인다고 생각하면 된다.
 *  - 도착점에 도달한 러너는 더 이상 이동하지 않아도 되는데,
 *    두 러너가 동시에 계속 움직여야 된다고 생각해서 틀렸었다.
 */
public class bfs_14451_speedRunner {

    static int N;
    // 북동남서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] rotate = {1, 3};
    static char[][] map;

    static int solve() {
        int ret = 0;

        boolean[][][][][][] visit = new boolean[N][N][4][N][N][4];
        visit[N - 1][0][0][N - 1][0][1] = true;

        Queue<Runner> q = new LinkedList<>();
        q.add(new Runner(N - 1, 0, 0, N - 1, 0, 1));

        while(!q.isEmpty()) {
            int size = q.size();

            // 매 시간 취할 수 있는 행동 : 전진 / 좌회전 / 우회전
            while(size-- > 0) {
                Runner now = q.poll();
                if(now.y1 == 0 && now.x1 == N - 1 && now.y2 == 0 && now.x2 == N - 1)
                    return ret;

                // 1) 전진
                int ny1 = now.y1;
                int nx1 = now.x1;
                if(ny1 != 0 || nx1 != N - 1) {
                    ny1 += dy[now.dir1];
                    nx1 += dx[now.dir1];
                    if(!canGo(ny1, nx1)) {
                        ny1 -= dy[now.dir1];
                        nx1 -= dx[now.dir1];
                    }
                }

                int ny2 = now.y2;
                int nx2 = now.x2;
                if(ny2 != 0 || nx2 != N - 1) {
                    ny2 += dy[now.dir2];
                    nx2 += dx[now.dir2];
                    if(!canGo(ny2, nx2)) {
                        ny2 -= dy[now.dir2];
                        nx2 -= dx[now.dir2];
                    }
                }

                if(!visit[ny1][nx1][now.dir1][ny2][nx2][now.dir2]) {
                    visit[ny1][nx1][now.dir1][ny2][nx2][now.dir2] = true;
                    q.add(new Runner(ny1, nx1, now.dir1, ny2, nx2, now.dir2));
                }

                // 2) 회전
                for(int dir = 0; dir < 2; dir++) {
                    int nDir1 = (now.dir1 + rotate[dir]) % 4;
                    int nDir2 = (now.dir2 + rotate[dir]) % 4;

                    if(!visit[now.y1][now.x1][nDir1][now.y2][now.x2][nDir2]) {
                        visit[now.y1][now.x1][nDir1][now.y2][now.x2][nDir2] = true;
                        q.add(new Runner(now.y1, now.x1, nDir1, now.y2, now.x2, nDir2));
                    }
                }
            }

            ret++;
        }


        return 0;
    }

    static boolean canGo(int y, int x) {
        return y >= 0 && x >= 0 && N > y && N > x && map[y][x] != 'H';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Runner {
        int y1, x1, dir1;
        int y2, x2, dir2;

        public Runner(int y1, int x1, int dir1, int y2, int x2, int dir2) {
            this.y1 = y1;
            this.x1 = x1;
            this.dir1 = dir1;
            this.y2 = y2;
            this.x2 = x2;
            this.dir2 = dir2;
        }
    }
}
