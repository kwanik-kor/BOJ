package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/17144
 */
public class sml_17144_goodbyeParticulates {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int R, C, T;
    static int[][] map;

    static int run(int upper, int lower) {
        while (T-- > 0) {
            spread();
            circulate(upper, lower);
        }

        return checkTotalParticulates();
    }

    static void spread() {
        int[][] temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] <= 0) continue;
                int spread = map[i][j] / 5;
                int cnt = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if (isOutOfRange(ny, nx) || map[ny][nx] == -1) continue;
                    cnt++;
                    temp[ny][nx] += spread;
                }

                temp[i][j] -= spread * cnt;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += temp[i][j];
            }
        }
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || R <= y || C <= x;
    }

    static void circulate(int upper, int lower) {
        // upper side
        int y = upper - 1;
        int x = 0;
        int dir = 0;
        while (true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (isOutOfRange(ny, nx) || ny > upper) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }

            if (map[ny][nx] == -1) {
                map[y][x] = 0;
                break;
            }
            map[y][x] = map[ny][nx];
            y = ny;
            x = nx;
        }

        y = lower + 1;
        x = 0;
        dir = 2;
        while (true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (isOutOfRange(ny, nx) || ny < lower) {
                dir = (dir + 3) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }

            if (map[ny][nx] == -1) {
                map[y][x] = 0;
                break;
            }
            map[y][x] = map[ny][nx];
            y = ny;
            x = nx;
        }
    }

    static int checkTotalParticulates() {
        int tot = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    tot += map[i][j];
                }
            }
        }
        return tot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int upper = 0; // 위쪽 공기청정기 position
        int lower = 0; // 아래쪽 공기청정기 position

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (upper == 0) {
                        upper = i;
                    } else {
                        lower = i;
                    }
                }
            }
        }

        bw.write(run(upper, lower) + "");
        bw.close();
        br.close();
    }

}
