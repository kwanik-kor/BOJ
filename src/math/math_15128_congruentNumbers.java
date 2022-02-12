package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15128
 */
public class math_15128_congruentNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long p1 = Long.parseLong(st.nextToken());
        long q1 = Long.parseLong(st.nextToken());
        long p2 = Long.parseLong(st.nextToken());
        long q2 = Long.parseLong(st.nextToken());

        bw.write(p1 * p2 % (q1 * q2 * 2) == 0 ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }
}
