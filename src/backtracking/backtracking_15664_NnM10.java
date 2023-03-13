package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/15664
 */
public class backtracking_15664_NnM10 {
    static int N, M;
    static int[] arr, ans;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        ans = new int[M];
        visit = new boolean[N];

        backtracking(0, 0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void backtracking(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int temp = 0;
        for (int i = start; i < N; i++) {
            if (!visit[i] && temp != arr[i]) {
                visit[i] = true;
                ans[cnt] = arr[i];
                temp = ans[cnt];
                backtracking(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }
}
