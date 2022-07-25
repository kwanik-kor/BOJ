package math;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2702
 */
public class math_02702_gcdLcm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = getGcd(Math.min(a, b), Math.max(a, b));
            bw.write(String.format("%d %d\n", a * b / gcd, gcd));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int getGcd(int a, int b) {
        if (a % b == 0) return b;
        return getGcd(b, a % b);
    }
}
