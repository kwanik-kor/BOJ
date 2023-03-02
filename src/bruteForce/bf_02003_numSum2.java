package bruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/2003
 */
public class bf_02003_numSum2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] < C) continue;
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == C) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");
        bw.close();
        br.close();
    }
}
