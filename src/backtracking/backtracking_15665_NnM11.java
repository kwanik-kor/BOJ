package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15665
 */
public class backtracking_15665_NnM11 {
    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        ans = new int[M];

        backtracking(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void backtracking(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (ans[cnt] == arr[i]) continue;
            ans[cnt] = arr[i];
            backtracking(cnt + 1);
        }
    }
}
