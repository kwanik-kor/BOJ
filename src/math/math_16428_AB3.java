package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/16428
 */
public class math_16428_AB3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        BigInteger div = a.divide(b);
        BigInteger rem = a.remainder(b);
        if(a.compareTo(BigInteger.ZERO) < 0 && !a.equals(BigInteger.ZERO) && b.compareTo(BigInteger.ZERO) > 0) {
            BigInteger divide = div.subtract(BigInteger.ONE);
            BigInteger remain = a.subtract(b.multiply(divide));
            bw.write(String.format("%s\n%s", divide.toString(), remain.toString()));
        } else if(a.compareTo(BigInteger.ZERO) < 0 && !a.equals(BigInteger.ZERO) && b.compareTo(BigInteger.ZERO) < 0) {
            BigInteger divide = div.add(BigInteger.ONE);
            BigInteger remain = a.subtract(b.multiply(divide));
            bw.write(String.format("%s\n%s", divide.toString(), remain.toString()));
        } else {
            bw.write(String.format("%s\n%s", div.toString(), rem.toString()));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
