package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/5692
 */
public class sml_05692_factorialNumber {

    static int[] flag = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        setupFlags();

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }

            int tot = 0;
            char[] arr = line.toCharArray();

            for (int i = 0, n = arr.length; i < n; i++) {
                tot += (int) (arr[i] - '0') * flag[n - i];
            }

            bw.write(tot + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void setupFlags() {
        flag[1] = 1;
        for (int i = 2; i <= 5; i++) {
            flag[i] = flag[i - 1] * i;
        }
    }
}
