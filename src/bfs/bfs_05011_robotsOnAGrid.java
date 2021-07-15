package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/5011
 * 2. 풀이
 *  - BFS + DP
 *  - 일반적인 BFS 를 통해서 시작점에서 끝점까지 갈 수 있는지 여부를 확인
 *    > 갈 수 없다면 INCONCEIVABLE 출력
 *  - 단순 BFS 로 최종 답을 출력 하면 메모리 초과!
 *  - 오른쪽과 아래쪽으로만 이동할 수 있기 때문에, DP를 이용해 경우의 수 체크
 */
public class bfs_05011_robotsOnAGrid {

    static final int MOD = 2147483647;

    static int N;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int[] dy2 = {-1, 0, 1, 0};
    static int[] dx2 = {0, 1, 0, -1};
    static char[][] map;
    static long[][] dp;

    static boolean isPossible() {
        boolean[][] visit = new boolean[N][N];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.y == N - 1 && now.x == N - 1)
                return true;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy2[dir];
                int nx = now.x + dx2[dir];
                if(ny < 0 || nx < 0 || N <= ny || N <= nx || visit[ny][nx] || map[ny][nx] == '#') continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return false;
    }

    static long solve() {
        dp[0][0] = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '#') continue;
                if(i + 1 < N) {
                    dp[i + 1][j] = (dp[i][j] % MOD  + dp[i + 1][j] % MOD) % MOD;
                }
                if(j + 1 < N) {
                    dp[i][j + 1] = (dp[i][j] % MOD + dp[i][j + 1] % MOD) % MOD;
                }
            }
        }
        return dp[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        if(!isPossible()) {
            bw.write("INCONCEIVABLE");
        } else {
            long ans = solve();
            bw.write(ans == 0L? "THE GAME IS A LIE" : String.valueOf(ans));
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
