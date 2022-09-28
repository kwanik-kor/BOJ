package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15917
 */
public class sml_15917_noSolveProtect {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            BigInteger bi = new BigInteger(br.readLine());
            if (bi.and(bi.multiply(new BigInteger("-1"))).equals(bi)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
