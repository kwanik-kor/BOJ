package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9506
 */
public class sml_09506_sumOfDivisor {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            StringJoiner sj = new StringJoiner(" + ");
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    sj.add(String.valueOf(i));
                }
                if (sum > n) break;
            }

            if (sum == n) {
                System.out.printf("%d = %s\n", n, sj.toString());
            } else {
                System.out.printf("%d is NOT perfect.\n", n);
            }
        }
    }
}
