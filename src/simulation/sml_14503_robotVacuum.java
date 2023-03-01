package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14503
 */
public class sml_14503_robotVacuum {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;
    static boolean[][] cleaned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        map = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robot.activate();

        bw.write(robot.getCleanedCnt() + "");
        bw.close();
        br.close();
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || N <= y || M <= x || map[y][x] == 1;
    }

    static class Robot {
        int y, x, dir;
        int cleanedCnt = 0;

        public Robot(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        public int getCleanedCnt() {
            return cleanedCnt;
        }

        void activate() {
            while (true) {
                if (!cleaned[y][x] && map[y][x] == 0) {
                    cleanedCnt++;
                    cleaned[y][x] = true;
                }

                int ny = y;
                int nx = x;
                if (checkNotCleanedAreaExist(y, x)) {
                    rotate();

                    ny += dy[dir];
                    nx += dx[dir];

                    if (isOutOfRange(ny, nx) || cleaned[ny][nx]) continue;
                } else {
                    int tempDir = (dir + 2) % 4;

                    ny += dy[tempDir];
                    nx += dx[tempDir];

                    if (isOutOfRange(ny, nx)) break;
                }
                y = ny;
                x = nx;
            }
        }

        boolean checkNotCleanedAreaExist(int y, int x) {
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (!isOutOfRange(ny, nx) && !cleaned[ny][nx]) {
                    return true;
                }
            }
            return false;
        }

        void rotate() {
            this.dir = (this.dir + 3) % 4;
        }
    }
}
