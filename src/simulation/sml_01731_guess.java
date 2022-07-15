package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1731
 */
public class sml_01731_guess {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        boolean isArithmetic = false;
        long gap = 0L;
        if (arr[2] - arr[1] == arr[1] - arr[0]) {
            isArithmetic = true;
            gap = arr[2] - arr[1];
        } else {
            gap = arr[2] / arr[1];
        }

        long ans = arr[N - 1];
        if (isArithmetic) ans += gap;
        else ans *= gap;

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
