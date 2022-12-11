package divideNConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10830
 */
public class dnc_10830_matrixPower {

    static int[][] A;
    static int N;

    static int[][] divide(long exponent) {
        if (exponent == 1L) {
            return A;
        }

        if (exponent % 2 == 0) {
            int[][] temp = divide(exponent / 2);
            return multiply(temp, temp);
        } else {
            return multiply(divide(exponent - 1), A);
        }
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                }
                ret[i][j] %= 1000;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = divide(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
