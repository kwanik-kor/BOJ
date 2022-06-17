package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10419
 */
public class math_10419_lateness {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = (int) Math.sqrt(n);
            while (true) {
                if (max * (max + 1) <= n) {
                    break;
                }
                max--;
            }
            bw.write(max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
