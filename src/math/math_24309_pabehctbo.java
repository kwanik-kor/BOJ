package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24309
 */
public class math_24309_pabehctbo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        BigInteger C = new BigInteger(br.readLine());
        bw.write(B.subtract(C).divide(A).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
