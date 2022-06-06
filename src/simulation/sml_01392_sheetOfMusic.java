package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1392
 */
public class sml_01392_sheetOfMusic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(br.readLine()) + dp[i - 1];
        }

        while (Q-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; i++) {
                if (n < dp[i]) {
                    bw.write(i + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
