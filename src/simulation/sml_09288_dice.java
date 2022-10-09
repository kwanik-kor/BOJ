package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9288
 */
public class sml_09288_dice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            bw.write(String.format("Case %d:\n", i));
            int X = Integer.parseInt(br.readLine());
            for (int n = 1; n <= 6; n++) {
                for (int m = n; m <= 6; m++) {
                    if (n + m == X) {
                        bw.write(String.format("(%d,%d)\n", n, m));
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
