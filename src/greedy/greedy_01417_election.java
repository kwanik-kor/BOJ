package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1417
 */
public class greedy_01417_election {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        if (N == 1) {
            bw.write("0");
        } else {
            Integer[] arr = new Integer[N - 1];
            for (int i = 0; i < N - 1; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int cnt = 0;
            while (A <= arr[0]) {
                A++;
                arr[0]--;
                cnt++;
                Arrays.sort(arr, Collections.reverseOrder());
            }

            bw.write(cnt + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
