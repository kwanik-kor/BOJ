package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1285
 */
public class greedy_01285_flipCoin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) == 'T' ? 1 : 0;
            }
        }

        int ans = N * N;
        for (int idx = 0, n = (1 << N) - 1; idx < n; idx++) {
            int tot = 0;

            for (int x = 0; x < N; x++) {
                int temp = 0;
                for (int y = 0; y < N; y++) {
                    int current = map[y][x];
                    if ((idx & (1 << y)) != 0) {
                        current = map[y][x] ^ 1;
                    }
                    if (current == 1) {
                        temp++;
                    }
                }
                tot += Math.min(temp, N - temp);
            }

            ans = Math.min(ans, tot);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
