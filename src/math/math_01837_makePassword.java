package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1837
 */
public class math_01837_makePassword {

    static boolean[] eratos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");

        int K = Integer.parseInt(line[1]);
        eratos = new boolean[K + 1];
        makeEratos(K);

        BigInteger target = new BigInteger(line[0]);
        boolean flag = true;
        for (int k = 2; k < K; k++) {
            if (eratos[k]) continue;
            if (target.mod(new BigInteger(String.valueOf(k))).equals(BigInteger.ZERO)) {
                flag = false;
                bw.write("BAD " + k);
                break;
            }
        }

        if (flag) {
            bw.write("GOOD");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void makeEratos(int k) {
        int sqrtMax = (int) Math.sqrt(k);
        eratos[0] = eratos[1] = true;

        for (int i = 2; i <= sqrtMax; i++) {
            if (eratos[i]) {
                for (int j = i * i; j <= k; j += i) {
                    eratos[j] = true;
                }
            }
        }
    }

}
