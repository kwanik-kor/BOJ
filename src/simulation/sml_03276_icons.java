package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/3276
 */
public class sml_03276_icons {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = Integer.MAX_VALUE;
        int row = 0;
        int col = 0;
        for (int i = 1; i <= n; i++) {
            int j = n % i == 0 ? n / i : (n / i + 1 );
            if (i + j < ans) {
                row = i;
                col = j;
                ans = i + j;
            }
        }
        bw.write(row + " " + col);
        bw.flush();
        bw.close();
        br.close();
    }
}
