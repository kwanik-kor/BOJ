package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/11689
 */
public class math_11689_gcd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long euler = n;
        long temp = 2;
        while (temp * temp <= n) {
            if (n % temp == 0) {
                euler = euler / temp * (temp - 1);
            }
            while (n % temp == 0) {
                n = n / temp;
            }
            temp++;
        }
        bw.write((n == 1 ? euler : euler / n * (n - 1)) + "");
        bw.close();
        br.close();
    }
}
