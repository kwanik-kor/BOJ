package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2210
 * 2. 풀이
 *  - 5 x 5 밖에 되지 않는 행렬이기 때문에 모든 노드에 대한 탐색을 진행할 수 있음
 *   > 또한 탐색의 거리 제한이 있기 때문에 가능함
 */
public class dfs_02210_jumpNumberPad {

    static final int N = 5;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map = new int[5][5];

    static HashSet<Integer> ans = new HashSet<>();

    static void getNum(Point start, int cnt, int num) {
        if(cnt == 5) {
            ans.add(num);
            return;
        }

        for(int dir = 0; dir < 4; dir++) {
            int ny = start.y + dy[dir];
            int nx = start.x + dx[dir];
            if(ny < 0 || nx < 0 || N <= ny || N <= nx) continue;
            getNum(new Point(ny, nx), cnt + 1, num + (int)Math.pow(10, N - cnt - 1) * map[ny][nx]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                getNum(new Point(i, j), 0, (int) Math.pow(10, N) * map[i][j]);
            }
        }
        bw.write(ans.size() + "");
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
