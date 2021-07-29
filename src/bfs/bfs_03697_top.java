package bfs;

import java.io.*;
import java.util.*;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/3697
 * 2. 풀이
 *  - 높은 위치부터 주어진 입력대로 순회를 하며, 정상인지 여부를 체크한다.
 *  - 시작점과 높이가 같은 곳을 발견한다면 정상의 개수를 늘려주고, 높은 곳을 만나면 정상이 아님을 flag로 담아둔다
 *   > 이전에는 계속 더 높은 곳을 만나면 그냥 return을 해버렸는데, 일단 전체적으로 순회를 한 번 해야 시간초과가
 *     안뜨는 것으로 보임
 */
public class bfs_03697_top {

    static int N, M, D;
    static int[][] map;
    static int[][] top;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int solve(Point point) {
        boolean isTop = true;
        int topCnt = 0;
        int dHeight = map[point.y][point.x] - D;

        Queue<Point> q = new LinkedList<>();
        q.add(point);
        top[point.y][point.x] = map[point.y][point.x];
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(map[now.y][now.x] == map[point.y][point.x])
                topCnt++;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx) continue;
                if(top[now.y][now.x] < top[ny][nx])
                    isTop = false;
                if(top[ny][nx] != -1 || map[ny][nx] <= dHeight) continue;
                top[ny][nx] = top[point.y][point.x];
                q.add(new Point(ny, nx, point.n));
            }
        }

        return isTop? topCnt : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            // Init
            map = new int[N][M];
            top = new int[N][M];
            List<Point> tops = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    top[i][j] = -1;
                    tops.add(new Point(i, j, map[i][j]));
                }
            }
            Collections.sort(tops);

            // Solve
            int ans = 0;
            for(Point p : tops) {
                if(top[p.y][p.x] == -1) {
                    ans += solve(p);
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int n;

        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }

        @Override
        public int compareTo(Point p) {
            return p.n - this.n;
        }
    }
}
