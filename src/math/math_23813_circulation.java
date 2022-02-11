package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/23813
 */
public class math_23813_circulation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String number = br.readLine();

        long ans = 0L;
        for(int i = 0, n = number.length(); i < n; i++) {
            number = number.charAt(n - 1) + number.substring(0, n - 1);
            ans += Long.parseLong(number);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
