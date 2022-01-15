package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/17202
 * 2. 풀이
 *  - 사실 정해진 길이에 연산이 복잡한 연산도 아니므로, 굳이 선계산하여 배열을 생성해둘 필요는 없음
 */
public class dp_17202_phoneCompatibility {

    static int[][] dp = new int[10][10];

    public static String solve(String phone) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0, n = phone.length(); i < n - 1; i++) {
            sb.append(dp[phone.charAt(i) - '0'][phone.charAt(i + 1) - '0']);
        }

        String ret = sb.toString();
        if(ret.length() == 2)
            return ret;

        return solve(ret);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();

        String start = combine(br.readLine(), br.readLine());
        bw.write(solve(start));

        bw.flush();
        bw.close();
        br.close();
    }

    static String combine(String a, String b) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0, n = a.length(); i < n; i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }

        return sb.toString();
    }

    static void init() {
        for(int i = 0; i < 10; i++) {
            for(int j = i; j < 10; j++) {
                dp[i][j] = dp[j][i] = (i + j) % 10;
            }
        }
    }
}
