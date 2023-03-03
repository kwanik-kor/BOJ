package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14499
 */
public class sml_14499_rollDice {
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dx = {1, -1, 0, 0};

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(y, x);

        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            dice.roll(Integer.parseInt(st.nextToken()) - 1);
        }

        System.out.print(dice.getMovement().trim());
        br.close();
    }

    static class Dice {
        int y, x;
        int[] num = new int[6];
        StringBuilder sb = new StringBuilder();

        public Dice(int y, int x) {
            this.y = y;
            this.x = x;
        }

        void roll(int dir) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || N <= ny || M <= nx) return;

            // 위, 동, 북, 서, 남, 밑
            int tmp = num[0];
            switch (dir) {
                case 0: // 동
                    num[0] = num[3];
                    num[3] = num[5];
                    num[5] = num[2];
                    num[2] = tmp;
                    break;
                case 1: // 서
                    num[0] = num[2];
                    num[2] = num[5];
                    num[5] = num[3];
                    num[3] = tmp;
                    break;
                case 2: // 남
                    num[0] = num[1];
                    num[1] = num[5];
                    num[5] = num[4];
                    num[4] = tmp;
                    break;
                default: // 북
                    num[0] = num[4];
                    num[4] = num[5];
                    num[5] = num[1];
                    num[1] = tmp;
            }

            if (map[ny][nx] == 0) {
                map[ny][nx] = num[5];
            } else {
                num[5] = map[ny][nx];
                map[ny][nx] = 0;
            }

            y = ny;
            x = nx;

            sb.append(num[0]).append("\n");
        }

        String getMovement() {
            return sb.toString();
        }
    }
}
