package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/24350
 */
public class dp_24350_НУЛИ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String comb = comb(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())).toString();
        int cnt = 0;
        for (int i = 0, n = comb.length(); i < n; i++) {
            if (comb.charAt(i) == '0') {
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static BigInteger comb(int n, int k) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            ret = ret.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }
        return ret;
    }
}
