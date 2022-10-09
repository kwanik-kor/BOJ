package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2061
 * 2. 풀이
 *   - 에라토스테네스의 체를 이용해 소수 판별을 함께 진행해줘야 함
 */
public class sml_02061_goodPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger K = new BigInteger(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[L + 1];
        prime[1] = true;

        boolean flag = true;
        for (int i = 2; i < L; i++) {
            if (prime[i]) continue;
            BigInteger bi = new BigInteger(Integer.toString(i));
            if (K.mod(bi).equals(BigInteger.ZERO)) {
                flag = false;
                bw.write("BAD " + i);
                break;
            }
            for (int j = i * 2; j <= L; j += i) {
                prime[j] = true;
            }
        }
        if (flag) {
            bw.write("GOOD");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
