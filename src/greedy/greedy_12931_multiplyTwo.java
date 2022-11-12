package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12931
 */
public class greedy_12931_multiplyTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cnt = 0;
        while (true) {
            boolean end = true;

            for (int i = 0; i < N; i++) {
                if (arr[i] > 1) {
                    end = false;
                }

                if (arr[i] % 2 == 1) {
                    cnt++;
                    arr[i]--;
                }
            }

            if (end) {
                break;
            }

            for (int i = 0 ; i < N; i++) {
                arr[i] /= 2;
            }
            cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
