package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/15312
 * 2. 풀이
 *  - 연산이 필요한 부분(3 + 7 = 0)을 미리 dp로 만들고 문자열을 줄여나감
 */
public class dp_15312_nameCompatibility {

    static final int[] COUNT = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static int[][] dp = new int[10][10];

    static String solve(String str) {
        if(str.length() == 2) return str;

        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length() - 1; i++) {
            sb.append(dp[str.charAt(i) - '0'][str.charAt(i + 1) - '0']);
        }

        return solve(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                dp[i][j] = (i + j) % 10;
            }
        }

        StringBuilder start = new StringBuilder();
        for(int i = 0; i < A.length; i++) {
            start.append(COUNT[A[i] - 'A']);
            start.append(COUNT[B[i] - 'A']);
        }

        bw.write(solve(start.toString()));
        bw.flush();
        bw.close();
        br.close();
    }
}
