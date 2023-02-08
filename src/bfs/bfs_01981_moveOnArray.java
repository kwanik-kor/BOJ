package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_01981_moveOnArray {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, min = 201, max = -1;
    static int ans;
    static int[][] map;

    static void binary(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    static boolean bfs(int diff) {
        for (int flag = min; flag + diff <= max; flag++) {
            int start = flag;
            int end = flag + diff;

            if (map[0][0] < start || end < map[0][0]) continue;

            boolean[][] visit = new boolean[N][N];

            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            visit[0][0] = true;

            while (!q.isEmpty()) {
                Integer now = q.poll();
                if (now / N == N - 1 && now % N == N - 1) {
                    return true;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = now / N + dy[dir];
                    int nx = now % N + dx[dir];

                    if (ny < 0 || nx < 0 || N <= ny || N <= nx || visit[ny][nx] || map[ny][nx] < start || end < map[ny][nx]) continue;

                    q.add(ny * N + nx);
                    visit[ny][nx] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        binary(0, max - min);

        bw.write(ans + "");
        bw.close();
        br.close();
    }
}
