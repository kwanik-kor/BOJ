package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1461
 */
public class greedy_01461_library {

    static int findZeroIndex(int[] arr) {
        for (int i = 0, n = arr.length; i < n; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int zeroIdx = findZeroIndex(arr);
        int ans = 0;
        for (int i = 0; i < zeroIdx; i += M) {
            ans += Math.abs(arr[i] * 2);
        }

        for (int i = N; i > zeroIdx; i -= M) {
            ans += arr[i] * 2;
        }

        ans -= Math.max(Math.abs(arr[0]), Math.abs(arr[N]));

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
