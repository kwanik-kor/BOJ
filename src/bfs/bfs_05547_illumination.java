package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5547
 * 2. 풀이
 *  - 바깥에서 보이는 지점만 둘레를 재야 하기 때문에, 바깥에서 좁혀들어가면서
 *   마주치는 곳의 수를 늘린다.
 */
public class bfs_05547_illumination {

    static int W, H;
    static int[] dy = {-1, -1, 0, 0, 1, 1};
    static int[] odd_dx = {-1, 0, -1, 1, -1, 0};
    static int[] even_dx = {0, 1, -1, 1, 0, 1};

    static int[][] map;

    static int solve() {
        int ret = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        map[0][0] = -1;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 6; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + (now.y % 2 == 0? odd_dx[dir] : even_dx[dir]);
                if(ny < 0 || nx < 0 || H + 1 < ny || W + 1 < nx || map[ny][nx] == -1) continue;
                if(map[ny][nx] == 1) {
                    ret++;
                }
                else {
                    map[ny][nx] = -1;
                    q.add(new Point(ny, nx));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 2][W + 2];
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
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
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
