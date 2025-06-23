package BOJ_27400;

import java.io.*;
import java.math.BigInteger;

/**
 * 정수 범위로 인해 BigInteger를 사용해야 하나, BigInteger 인스턴스
 */
public class BOJ_27434 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        bw.write(factorial(1, N) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static BigInteger factorial(int a, int b) {
        if (a >= b) {
            return BigInteger.valueOf(a);
        }

        int mid = (a + b) / 2;

        return factorial(a, mid).multiply(factorial(mid + 1, b));
    }
}
