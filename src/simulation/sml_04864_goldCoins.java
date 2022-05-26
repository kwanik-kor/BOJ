package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4864
 */
public class sml_04864_goldCoins {

    static int[] sum = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            bw.write(n + " " + sum[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        int idx = 1;
        for (int i = 1; i <= 150; i++) {
            if (idx > 10000) break;
            for (int j = 0; j < i; j++) {
                if (idx > 10000) break;
                sum[idx] = sum[idx - 1] + i;
                idx++;
            }
        }
    }
}
