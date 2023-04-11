package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14397
 */
public class greedy_14397_beach {
    private static final Character BEACH = '.', LAND = '#';
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0;
        char[][] map = new char[N][M];
        for (int row = 0; row < N; row++) {
            map[row] = br.readLine().toCharArray();
            for (int col = 0; col < M; col++) {
                char comparison = map[row][col] == BEACH ? LAND : BEACH;
                if (!isOutOfRange(row, col - 1) && map[row][col - 1] == comparison) {
                    cnt++;
                }
                if (!isOutOfRange(row - 1, col) && map[row - 1][col] == comparison) {
                    cnt++;
                }

                int compCol = row % 2 == 1 ? (col + 1) : (col - 1);
                if (!isOutOfRange(row - 1, compCol) && map[row - 1][compCol] == comparison) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");
        bw.close();
        br.close();
    }

    private static boolean isOutOfRange(int row, int col) {
        return row < 0 || col < 0 || N <= row || M <= col;
    }
}
