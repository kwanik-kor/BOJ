package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4812
 * 2. 풀이
 *  - 로봇이 취할 수 있는 움직임을 그대로 BFS로 구현
 *    > 단, Direction 을 배열에 추가해 동일한 Distance 와 Direction 으로 특정 지점에 들어갈 수 있다면
 *      해당 지점으로 갈 수 있는 경로의 수를 count up 해줌
 *    >> BFS + DP!!
 * 3. 삽질기
 *  - input 으로 "0 0 0"이 들어올 때 종료되는 것이 아니라 modula 가 0일 경우에 종료되는 것이었음
 *    > 두 번 NullPointer ㅠㅠㅠㅠㅠㅠ
 *  - modula 가 1이 될 수도 있음을 간과하고 return 받은 값이 0일 경우에는 -1로 프린트하게 함
 *    > 1번 틀림 ㅠㅠㅠㅠㅠㅠ
 */
public class bfs_4812_robotNavigation {

    static StringTokenizer st;
    static final int INF = 987654321;

    static int M, N, MOD;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static String direction = "NESW";     // 북, 동, 남, 서

    static boolean[][] map;
    static int[][][] dist;
    static int[][][] cnt;
    static Point start, end;

    static int solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        dist[start.dir][start.y][start.x] = 0;
        cnt[start.dir][start.y][start.x] = 1;

        int mindist = -1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == end.y && now.x == end.x) {
                mindist = dist[now.dir][now.y][now.x];
                break;
            }

            for(int dir = 0; dir < 4; dir++) {
                if(now.dir == dir) { // 로봇 방향과 진행 방향이 동일하다면
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];

                    if(ny < 0 || nx < 0 || M <= ny || N <= nx) continue;

                    if(map[ny][nx] && dist[dir][now.y][now.x] + 1 < dist[dir][ny][nx]) {
                        dist[dir][ny][nx] = dist[dir][now.y][now.x] + 1;
                        cnt[dir][ny][nx] = (cnt[dir][ny][nx] % MOD + cnt[dir][now.y][now.x] % MOD) % MOD;
                        q.add(new Point(ny, nx, dir));
                    } else if(map[ny][nx] && dist[dir][now.y][now.x] + 1 == dist[dir][ny][nx]) {
                        cnt[dir][ny][nx] = (cnt[dir][ny][nx] % MOD + cnt[dir][now.y][now.x] % MOD) % MOD;
                    }
                } else if(Math.abs(now.dir - dir) != 2) { // 90도 돌리는 case
                    if(dist[now.dir][now.y][now.x] + 1 < dist[dir][now.y][now.x]) {
                        dist[dir][now.y][now.x] = dist[now.dir][now.y][now.x] + 1;
                        cnt[dir][now.y][now.x] = (cnt[now.dir][now.y][now.x] % MOD + cnt[dir][now.y][now.x] % MOD) % MOD;
                        q.add(new Point(now.y, now.x, dir));
                    } else if(dist[now.dir][now.y][now.x] + 1 == dist[dir][now.y][now.x]) {
                        cnt[dir][now.y][now.x] = (cnt[now.dir][now.y][now.x] % MOD + cnt[dir][now.y][now.x] % MOD) % MOD;
                    }
                }
            }
        }
        if(mindist < 0)
            return -1;

        int ret = 0;
        for(int i = 0; i < 4; i++) {
            if(dist[i][end.y][end.x] == mindist) {
                ret = (ret % MOD + cnt[i][end.y][end.x] % MOD) % MOD;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNo = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            MOD = Integer.parseInt(st.nextToken());

            if(MOD == 0) break;

            map = new boolean[M][N];
            dist = new int[4][M][N];
            cnt = new int[4][M][N];
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < M; j++) {
                    Arrays.fill(dist[i][j], INF);
                }
            }

            for(int i = 0; i < M; i++) {
                char[] arr = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    if(arr[j] == '.')
                        map[i][j] = true;
                }
            }

            st = new StringTokenizer(br.readLine());
            int start_y = Integer.parseInt(st.nextToken());
            int start_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int startDir = direction.indexOf(st.nextToken());

            start = new Point(start_y, start_x, startDir);
            end = new Point(end_y, end_x, 0);

            int ans = solve();

            bw.write(String.format("Case %d: %d %d\n", caseNo++, MOD, ans));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int dir;
        public Point(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

}
