package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/6148
 */
public class backtracking_06148_bookshelf2 {

    static int N, H, ans = Integer.MAX_VALUE;
    static int[] height;
    static boolean[] visit;

    static void backtracking(int start, int n, int tot) {
        if (tot >= H) {
            ans = Math.min(ans, tot - H);
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = true;
            backtracking(i + 1, n + 1, tot + height[i]);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        height = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        backtracking(0, 0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
