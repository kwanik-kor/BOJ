package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12100
 */
public class dfs_12100_2048 {
    static int N;
    static int ans = 0;
    static int[][] map = new int[22][22];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, map[i][j]);
            }
        }

        dfs(0);

        bw.write(ans + "");
        bw.close();
        br.close();
    }

    private static void dfs(int cnt) {
        if (cnt == 5) {
            findMax();
            return;
        }

        int[][] temp = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
        for (int dir = 0; dir < 4; dir++) {
            move(dir);
            dfs(cnt + 1);
            map = Arrays.stream(temp).map(int[]::clone).toArray(int[][]::new);
        }
    }

    private static void move(int dir) {
        Queue<Integer> q = new LinkedList<>();

        if (dir == 0) { // 북쪽
            for (int j = 1; j <= N; j++) {
                for (int i = 1; i <= N; i++) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int row = 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[row][j] == 0) map[row][j] = now;
                    else if (map[row][j] == now) map[row++][j] *= 2;
                    else map[++row][j] = now;
                }
            }
        } else if (dir == 1) { // 남쪽
            for (int j = 1; j <= N; j++) {
                for (int i = N; i >= 1; i--) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int row = N;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[row][j] == 0) map[row][j] = now;
                    else if (map[row][j] == now) map[row--][j] *= 2;
                    else map[--row][j] = now;
                }
            }
        } else if (dir == 2) { // 서쪽
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int col = 1;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[i][col] == 0) map[i][col] = now;
                    else if (map[i][col] == now) map[i][col++] *= 2;
                    else map[i][++col] = now;
                }
            }
        } else if (dir == 3) {
            for (int i = 1; i <= N; i++) {
                for (int j = N; j >= 1; j--) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int col = N;
                while (!q.isEmpty()) {
                    int now = q.poll();
                    if (map[i][col] == 0) map[i][col] = now;
                    else if (map[i][col] == now) map[i][col--] *= 2;
                    else map[i][--col] = now;
                }
            }
        }
    }

    private static void findMax() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans = Math.max(ans, map[i][j]);
            }
        }
    }

}
