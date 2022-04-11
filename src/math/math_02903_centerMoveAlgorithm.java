package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2903
 */
public class math_02903_centerMoveAlgorithm {

    static long[] arr = new long[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr[0] = 2L;
        for(int i = 1; i <= 15; i++) {
            arr[i] = arr[i - 1] * 2 - 1;
        }

        bw.write(arr[N] * arr[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
