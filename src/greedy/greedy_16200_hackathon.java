package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/16200
 */
public class greedy_16200_hackathon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        Arrays.sort(arr);

        boolean[] selected = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;

            int temp = arr[i];
            while (temp > 0) {
                if (i >= N) break;
                selected[i] = true;
                temp--;
                i++;
            }
            i--;
            cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
