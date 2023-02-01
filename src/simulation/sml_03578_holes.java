package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3578
 */
public class sml_03578_holes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            bw.write("1");
        } else if (N == 1) {
            bw.write("0");
        } else {
            int n = N / 2;
            if (N % 2 != 0) {
                bw.write("4");
            }
            for (int i = 0; i < n; i++) {
                bw.write("8");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
