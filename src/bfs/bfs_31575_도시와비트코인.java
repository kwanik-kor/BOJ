package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_31575_도시와비트코인 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] DY = {1, 0};
    private static final int[] DX = {0, 1};

    static boolean solve(int m, int n, boolean[][] map) {
        final boolean[][] visited = new boolean[m][n];
        final Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            int y = current / n;
            int x = current % n;
            if (y == m - 1 && x == n - 1) {
                return true;
            }

            for (int dir = 0; dir < 2; dir++) {
                int ny = y + DY[dir];
                int nx = x + DX[dir];

                if (ny < 0 || nx < 0 || ny >= m || nx >= n || !map[ny][nx] || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(ny * n + nx);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        final boolean[][] map = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        bw.write(solve(m, n, map) ? "Yes" : "No");

        bw.flush();
        bw.close();
        br.close();
    }
}
