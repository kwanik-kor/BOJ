package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14720
 */
public class sml_14720_milkFestival {

    static final int STRAWBERRY = 0, CHOCOLATE = 1, BANANA = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int cnt = 0;
        int start = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == STRAWBERRY && (start == -1 || start == BANANA)) {
                start = STRAWBERRY;
                cnt++;
            }

            if (arr[i] == CHOCOLATE && start == STRAWBERRY) {
                start = CHOCOLATE;
                cnt++;
            }

            if (arr[i] == BANANA && start == CHOCOLATE) {
                start = BANANA;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
