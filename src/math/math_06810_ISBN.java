package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6810
 */
public class math_06810_ISBN {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String no = "9780921418";
        for(int i = 0; i < 3; i++)
            no += br.readLine();

        int ret = 0;
        for(int i = 0, n = no.length(); i < n; i++) {
            ret += (no.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
        }

        bw.write(String.format("The 1-3-sum is %d", ret));
        bw.flush();
        bw.close();
        br.close();
    }
}
