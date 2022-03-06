package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2921
 */
public class math_02921_domino {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long tot = 0L;
        for(int i = 1; i <= N; i++) {
            tot += (long) i * (i + 1) + (long) (i) * (i + 1) / 2;
        }

        bw.write(tot + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
