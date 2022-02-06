package prefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/2435
 * 2. 풀이
 *  - 누적합의 기본적인 형태의 문제
 *   > 입력받은 값을 모두 누적해서 합을 더해둔 다음, K 배열 길이만큼 배주면 됨
 */
public class ps_02435_internKMA {

    static int N, K;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sum = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int ans = -100_001;
        for(int i = K; i <= N; i++) {
            ans = Math.max(ans, sum[i] - sum[i - K]);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
