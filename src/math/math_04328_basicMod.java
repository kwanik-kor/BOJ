package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4328
 */
public class math_04328_basicMod {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            if (b == 0) break;
            BigInteger a1 = new BigInteger(st.nextToken(), b);
            BigInteger a2 = new BigInteger(st.nextToken(), b);
            bw.write(a1.mod(a2).toString(b) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
