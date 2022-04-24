package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/10480
 */
public class math_10480_oddities {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 0)
                bw.write(String.format("%d is even\n", n));
            else
                bw.write(String.format("%d is odd\n", n));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
