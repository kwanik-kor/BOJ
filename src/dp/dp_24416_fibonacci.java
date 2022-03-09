package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/24416
 * 2. 풀이
 *  - 재귀호출 의사코드에서 1이 반환되는 횟수는 n번째 피보나치수를 구하는 것과 동일함.
 *  - DP를 이용한 구현은 처음 두 항에 대해 제외되기 때문에 n-2 번 수행됨
 */
public class dp_24416_fibonacci {

    static int[] dp;

    static int fib(int n) {
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        bw.write(fib(n) + " " + (n - 2) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
