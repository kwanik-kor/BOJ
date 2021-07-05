package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2194
 * 2. 풀이
 *  - 장애물이 위치한 장소를 누적합으로 미리 표시를 해둠.
 *  - 이동하고자 하는 방향으로 움직였을 때, 유닛 면적의 누적합이 0보다 크다면 장애물에 걸치는 상황
 *    - 해당 상황은 지나가지 못하는 것으로 처리
 *  - Input이나 시간제한이 까다롭지 않은 문제이기 때문에, 단순 case처리로 풀어도 됨
 *
 * 3. 유사문제
 *  - 16973번 직사각형 탈출 : https://www.acmicpc.net/problem/16973
 */
public class bfs_2194_unitmove {

    static int N, M, A, B, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static Point start, end;

    static int solve() {
        boolean[][] visit = new boolean[N + 1][M + 1];

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
               if(ny <= 0 || nx <= 0 || N < ny + A - 1 || M < nx + B - 1 || visit[ny][nx]) continue;
               if(canMove(ny, nx)) {
                   visit[ny][nx] = true;
                   q.add(new Point(ny, nx, now.n + 1));
               }
            }
        }

        return -1;
    }

    // 이동하고자 하는 방향에 장애물이 있는지 검사
    static boolean canMove(int y, int x) {
        return map[y + A - 1][x + B - 1] - map[y - 1][x + B - 1] - map[y + A - 1][x - 1] + map[y - 1][x - 1] <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(br.readLine());
        start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        st = new StringTokenizer(br.readLine());
        end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        // 누적합 Setting
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                map[i][j] += map[i][j - 1];
            }
        }
        for(int j = 1; j <= M; j++) {
            for(int i = 1; i <= N; i++) {
                map[i][j] += map[i - 1][j];
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
        Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }

}
