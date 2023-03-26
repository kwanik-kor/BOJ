package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2851
 */
public class greedy_02851_superMario {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tot = 0;
        int sub = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int tmp = tot + n;
            if (Math.abs(tmp - 100) <= sub) {
                tot = tmp;
                sub = Math.abs(tmp - 100);
            } else {
                break;
            }
        }

        System.out.println(tot);
    }
}
