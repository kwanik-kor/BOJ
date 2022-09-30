package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15841
 * 2. 풀이
 *  - 피보나치 수열 490 길이에 대해서 생각 안해보고 풀었다가 자꾸 틀림...
 *  - 기본적인 실수는 하지말자..
 */
public class dp_15841_virusOutbreak {

    static BigInteger[] dp = new BigInteger[491];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= 490; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        while (true) {
            int time = Integer.parseInt(br.readLine());
            if (time == -1) {
                break;
            }
            bw.write(String.format("Hour %d: %s cow(s) affected\n", time, dp[time].toString()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
