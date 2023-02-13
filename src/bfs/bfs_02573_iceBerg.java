package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_02573_iceBerg {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;
    static int[][] ocean;
    static int[][] district;

    static int solve() {
        int year = 0;

        while (true) {
            year++;

            List<Integer> icebergs = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        icebergs.add(i * M + j);
                    }
                }
            }

            if (icebergs.size() == 0) {
                return 0;
            }

            checkOcean(icebergs);

            for (Integer iceberg : icebergs) {
                int y = iceberg / M;
                int x = iceberg % M;
                map[y][x] -= ocean[y][x];
                if (map[y][x] < 0) map[y][x] = 0;
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(district[i], 0);
            }

            int num = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && district[i][j] == 0) {
                        checkDistrict(i, j, ++num);
                    }
                }
            }

            if (num > 1) {
                break;
            }
        }

        return year;
    }

    static void checkOcean(List<Integer> icebergs) {
        for (Integer point : icebergs) {
            int y = point / M;
            int x = point % M;

            int cnt = 0;
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (isOutOfRange(ny, nx)) continue;
                if (map[ny][nx] == 0) {
                    cnt++;
                }
            }
            ocean[y][x] = cnt;
        }
    }

    static void checkDistrict(int y, int x, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y * M + x);
        district[y][x] = n;

        while(!q.isEmpty()) {
            Integer now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = now / M + dy[dir];
                int nx = now % M + dx[dir];

                if (isOutOfRange(ny, nx) || map[ny][nx] == 0 || district[ny][nx] != 0) continue;

                q.add(ny * M + nx);
                district[ny][nx] = n;
            }
        }
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || M <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ocean = new int[N][M];
        district = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
