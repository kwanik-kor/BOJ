package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1559
 * 2. 풀이
 *  - 찾은 보물과 방문한 노드에 대한 visit 처리가 핵심이었던 문제
 *  - 최대 8개의 보물이기 때문에 비트마스킹으로 처리가능
 *    > 보물을 입력받는 시점에 임의로 번호를 붙여줘야 한다.
 *  - 문은 4번 회전할 경우 제자리이기 때문에, 길이 4의 배열로 잡아주면 됨
 */
public class bfs_01559_amazingMaze {

    static final String DIRECTION = "NESW";

    static int M, N, K;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map, treasure;
    static boolean[][][][] visit;

    static int solve() {
        int time = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));

        visit = new boolean[M][N][4][256];
        visit[0][0][3][0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Point now = q.poll();
                int n = now.n;

                if(0 <= treasure[now.y][now.x]) { // 비트마스킹으로 찾은 보물 표시
                    n |= (1 << treasure[now.y][now.x]);
                }
                if(n == (1 << K) - 1 && now.y == M - 1 && now.x == N - 1)
                    return time;

                // 제자리 뺑글뺑글쓰
                if(!visit[now.y][now.x][time % 4][n]) {
                    visit[now.y][now.x][time % 4][n] = true;
                    q.add(new Point(now.y, now.x, n));
                }

                int ny = now.y + dy[(map[now.y][now.x] + time) % 4];
                int nx = now.x + dx[(map[now.y][now.x] + time) % 4];

                if(ny < 0 || nx < 0 || M <= ny || N <= nx || visit[ny][nx][time % 4][n]) continue;

                visit[ny][nx][time % 4][n] = true;
                q.add(new Point(ny, nx, n));
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(M == 0 && N == 0) break;

            map = new int[M][N];
            treasure = new int[M][N];
            for(int i = 0; i < M; i++) {
                char[] carr = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    map[i][j] = DIRECTION.indexOf(carr[j]);
                    treasure[i][j] = -1;
                }
            }

            K = Integer.parseInt(br.readLine());
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                treasure[a][b] = k;
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
        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }

}
