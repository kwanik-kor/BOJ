package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1247
 */
public class sml_01247_sign {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 3;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            while (N-- > 0) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            if (sum.equals(BigInteger.ZERO)) {
                bw.write("0\n");
            } else if (sum.compareTo(BigInteger.ZERO) < 0) {
                bw.write("-\n");
            } else {
                bw.write("+\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
