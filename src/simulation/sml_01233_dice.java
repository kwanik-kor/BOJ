package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1233
 */
public class sml_01233_dice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

        int[] sum = new int[arr[0] + arr[1] + arr[2] + 1];
        for (int i = 1; i <= arr[0]; i++) {
            for (int j = 1; j <= arr[1]; j++) {
                for (int k = 1; k <= arr[2]; k++) {
                    sum[i + j + k]++;
                }
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 1, n = sum.length; i < n; i++) {
            if (sum[i] > cnt) {
                cnt = sum[i];
                max = i;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
