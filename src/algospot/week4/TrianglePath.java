package algospot.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.algospot.com/judge/problem/read/TRIANGLEPATH
 */
public class TrianglePath {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static final int[][] map = new int[101][101];
    static final int[][] memo = new int[101][101];


    public static void main(String[] args) throws Exception {
        TrianglePath main = new TrianglePath();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            main.solve();
        }
    }

    private void solve() throws Exception {
        initializeMap();

        System.out.println(dp(0, 0));
    }

    private int dp(int y, int x) {
        if (y == n - 1 || memo[y][x] != -1) {
            return memo[y][x];
        }

        return memo[y][x] = Math.max(dp(y + 1, x), dp(y + 1, x + 1)) + map[y][x];
    }

    private void initializeMap() throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
                if (i == n - 1) {
                    memo[i][j] = map[i][j];
                }
            }
        }
    }

}
