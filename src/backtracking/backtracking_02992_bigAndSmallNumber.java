package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2992
 */
public class backtracking_02992_bigAndSmallNumber {
    static int max = 1000000;
    static char[] arr;
    static int n, originNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        originNum = Integer.parseInt(br.readLine());
        arr = String.valueOf(originNum).toCharArray();
        n = arr.length;

        backtracking(0, 0, new boolean[n]);
        bw.write((max == 1000000 ? 0 : max) + "");
        bw.close();
        br.close();
    }


    static void backtracking(int cnt, int num, boolean[] visit) {
        if (num >= max) {
            return;
        }

        if (cnt == n && num > originNum) {
            max = Math.min(max, num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            backtracking(cnt + 1, num * 10 + (arr[i] - '0'), visit);
            visit[i] = false;
        }
    }

}
