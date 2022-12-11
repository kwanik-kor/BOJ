package divideNConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1780
 */
public class dnc_01780_paperCount {

    static int[][] map;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void divide(int row, int col, int size) {
        if (!check(row, col, size)) {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + newSize * i, col + newSize * j, newSize);
                }
            }
        }
    }

    static boolean check(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[row][col] != map[i][j]) {
                    return false;
                }
            }
        }

        result[map[row][col]]++;
        return true;
    }

}
