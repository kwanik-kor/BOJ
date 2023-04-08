package algospot.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static boolean isArrived;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int[][] map = new int[101][101];
    static boolean[][] visit = new boolean[101][101];

    public static void main(String[] args) throws Exception {
        JumpGame game = new JumpGame();
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            game.solve();
        }
    }

    private void solve() throws Exception {
        initializeBoard();

        dfs(0, 0);

        System.out.println(isArrived ? "YES" : "NO");
    }

    private void dfs(int y, int x) {
        if (y == n - 1 && x == n - 1) {
            isArrived = true;
            return;
        }

        if (isArrived) {
            return;
        }

        for (int dir = 0; dir < 2; dir++) {
            int ny = y + dy[dir] * map[y][x];
            int nx = x + dx[dir] * map[y][x];

            if (isOutOfRange(ny, nx)) continue;

            visit[ny][nx] = true;
            dfs(ny, nx);
        }
    }

    private boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || n <= y || n <= x || visit[y][x];
    }

    private void initializeBoard() throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = false;
            }
        }

        isArrived = false;
        visit[0][0] = true;
    }

}
