package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16985
 * 2. 풀이
 *  - 사실상 구현에 큰 힘이 실려있는 문제
 *  - Rotate와 Permutation을 잘 구현해준다면, BFS로 최소경로만 찾아내면 된다.
 *   - Rotate와 Permutation은 아래 코드 참고!
 *    >> c++의 next_permutation 너무 부럽고...
 */
public class bfs_16985_maaaaaaaaze {

    static final int INF = 987654321;
    static final int CASES = 1023;
    static final int N = 5;

    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    // 층, 행, 열
    static int[][][] map = new int[N][N][N];
    static int[][][] dist = new int[N][N][N];
    static int[][][][] rotated = new int[4][N][N][N];

    static int ans = INF;
    static int[] floors = new int[N];
    static boolean[] visit = new boolean[N];

    // 최단경로 탐색
    static void bfs() {
        if(map[0][0][0] == 0 || map[4][4][4] == 0) return;

        initDist();

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        dist[0][0][0] = 0;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(ans <= dist[now.z][now.y][now.x])
                return;

            if(now.y == 4 && now.x == 4 && now.z == 4) {
                ans = Math.min(ans, dist[4][4][4]);
                return;
            }
            for(int dir = 0; dir < 6; dir++) {
                int nz = now.z + dz[dir];
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || nz < 0 || N <= ny || N <= nx || N <= nz || map[nz][ny][nx] == 0 || dist[nz][ny][nx] != -1) continue;
                dist[nz][ny][nx] = dist[now.z][now.y][now.x] + 1;
                q.add(new Point(nz, ny, nx));
            }
        }
    }

    // 거리 초기화
    static void initDist() {
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                Arrays.fill(dist[k][i], -1);
            }
        }
    }

    // 층수 순열과 Rotate 조합에 맞게 Map 재배열
    static void setNewMapAndSolve(int type) {
        for(int k = 0; k < N; k++) {
            int dir = type & 3;
            type >>= 2;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[k][i][j] = rotated[dir][floors[k]][i][j];
                }
            }
        }

        bfs();

    }

    // 순열
    static void permutation(int cnt) {
        if(cnt == N) {
            for(int c = 0; c < CASES; c++) {
                setNewMapAndSolve(c);
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            floors[cnt] = i;
            permutation(cnt + 1);
            visit[i] = false;
        }

    }

    // 회전된 판때기 미리 만들어 놓기
    static void rotateFloor() {
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    rotated[0][k][i][j] = map[k][i][j];
                }
            }
        }

        for(int dir = 1; dir < 4; dir++) {
            for(int k = 0; k < N; k++) {
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        rotated[dir][k][i][j] = rotated[dir - 1][k][N - j - 1][i];
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        rotateFloor();

        permutation(0);

        bw.write(ans == INF? "-1" : (ans + ""));

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int z;
        int y;
        int x;
        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
