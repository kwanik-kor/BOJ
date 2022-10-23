package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/23972
 */
public class sml_23972_suggestionOfDevil {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        if (N == 1) {
            bw.write("-1");
        } else {
            BigInteger k = new BigInteger(String.valueOf(K));
            BigInteger n = new BigInteger(String.valueOf(N));
            if (!k.multiply(n).mod(n.subtract(BigInteger.ONE)).equals(BigInteger.ZERO)) {
                bw.write(k.multiply(n).divide(n.subtract(BigInteger.ONE)).add(BigInteger.ONE).toString());
            } else {
                bw.write(k.multiply(n).divide(n.subtract(BigInteger.ONE)).toString());
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
